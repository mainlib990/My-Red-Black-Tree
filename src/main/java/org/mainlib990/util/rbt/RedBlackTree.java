package org.mainlib990.util.rbt;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

import static org.mainlib990.util.rbt.MyTreeOperators.*;

public class RedBlackTree<E> {

    private final Comparator<? super E> comparator;

    private MyTree<E> root;

    @SuppressWarnings("unchecked")
    public RedBlackTree() {
        this((Comparator<? super E>) Comparator.naturalOrder());
    }

    public RedBlackTree(Comparator<? super E> comparator) {

        this.comparator = Objects.requireNonNull(comparator);
        root = MyTrees.nil();
    }

    public void add(E value) {

        Objects.requireNonNull(value);
        root = add(root, value);
        root.color(Color.BLACK);
    }

    private MyTree<E> add(MyTree<E> current, E value) {

        return Optional.of(current)
                .filter(isNotNil())
                .map(ifAllRedChildren(colorFlips()))
                .flatMap(ifLessOrMore(value,
                        v -> currentOpt -> currentOpt
                                .map(addToLeftChild(v))
                                .map(ifLRCase(leftChildTo(rotateLeft())))
                                .map(ifLLCase(rotateRight())),
                        v -> currentOpt -> currentOpt
                                .map(addToRightChild(v))
                                .map(ifRLCase(rightChildTo(rotateRight())))
                                .map(ifRRCase(rotateLeft()))))
                .orElseGet(newNormal(value));
    }

    private Function<MyTree<E>, Optional<MyTree<E>>> ifLessOrMore(E value,
                                                                  Function<E, UnaryOperator<Optional<MyTree<E>>>> lessOperator,
                                                                  Function<E, UnaryOperator<Optional<MyTree<E>>>> moreOperator) {

        return current -> {

            Optional<MyTree<E>> currentOpt = Optional.of(current);

            int compare = comparator.compare(current.value(), value);
            if (compare > 0) {
                return lessOperator.apply(value).apply(currentOpt);
            } else if (compare < 0) {
                return moreOperator.apply(value).apply(currentOpt);
            }
            return currentOpt;
        };
    }

    private UnaryOperator<MyTree<E>> addToLeftChild(E value) {

        return current -> {

            MyTree<E> newLeft = add(current.left(), value);
            current.left(newLeft);

            return current;
        };
    }

    private UnaryOperator<MyTree<E>> addToRightChild(E value) {

        return current -> {

            MyTree<E> newRight = add(current.right(), value);
            current.right(newRight);

            return current;
        };
    }

    public void remove(E value) {

        Objects.requireNonNull(value);
        root = remove(root, value);
        root.color(Color.BLACK);
    }

    private MyTree<E> remove(MyTree<E> current, E value) {

        return Optional.of(current)
                .filter(isNotNil())
                .flatMap(ifLessOrMoreEqual(
                        value,
                        v -> currentOpt -> currentOpt
                                .map(ifLeftIsBlack(moveRedLeft()))
                                .map(removeToLeftChild(v))
                                .map(ifRCase(rotateLeft())),
                        v -> currentOpt -> currentOpt
                                .map(ifRightIsBlack(moveRedRight()))
                                .map(removeToRightChild(v))
                                .map(ifLCase(rotateRight()))))
                .map(ifAllRedChildren(colorFlips()))
                .orElseGet(nil());
    }

    private Function<MyTree<E>, Optional<MyTree<E>>> ifLessOrMoreEqual(E value,
                                                                       Function<E, UnaryOperator<Optional<MyTree<E>>>> lessOperator,
                                                                       Function<E, UnaryOperator<Optional<MyTree<E>>>> moreEqualOperator) {

        return current -> {

            Optional<MyTree<E>> currentOpt = Optional.of(current);

            int compare = comparator.compare(current.value(), value);
            if (compare > 0) {
                return lessOperator.apply(value).apply(currentOpt);
            }
            return moreEqualOperator.apply(value).apply(currentOpt);
        };
    }

    private UnaryOperator<MyTree<E>> removeToLeftChild(E value) {

        return current -> {

            MyTree<E> newLeft = remove(current.left(), value);
            current.left(newLeft);

            return current;
        };
    }

    private UnaryOperator<MyTree<E>> removeToRightChild(E value) {

        return current -> {

            int compare = comparator.compare(current.value(), value);
            if (compare == 0) {

                MyTree<E> minTree = MyTrees.min(current.right());
                if (MyTrees.isNil(minTree)) {
                    return MyTrees.nil();
                }

                E minValue = minTree.value();
                current.value(minValue);

                MyTree<E> newRight = remove(current.right(), minValue);
                current.right(newRight);
            } else {

                MyTree<E> newRight = remove(current.right(), value);
                current.right(newRight);
            }

            return current;
        };
    }

    public E[] toArray(IntFunction<E[]> generator) {
        return MyTrees.toArray(root, generator);
    }

    @Override
    public String toString() {
        return MyTrees.toString(root);
    }
}
