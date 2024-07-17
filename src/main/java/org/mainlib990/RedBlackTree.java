package org.mainlib990;

import java.util.Optional;
import java.util.function.IntFunction;

import static org.mainlib990.MyTreeOperators.*;

public class RedBlackTree<E extends Comparable<E>> {

    private MyTree<E> root;

    public RedBlackTree() {
        root = MyTrees.nil();
    }

    public void add(E value) {

        root = add(root, value);
        root.color(Color.BLACK);
    }

    private MyTree<E> add(MyTree<E> current, E value) {

        if (MyTrees.isNil(current)) {
            return MyTrees.newNormal(value);
        }

        current = Optional.of(current)
                .map(ifHasAllRedChildren(colorFlips()))
                .orElseThrow();

        int compare = MyTrees.compare(current, value);
        if (compare > 0) {

            current.left(add(current.left(), value));

            current = Optional.of(current)
                    .map(ifLRCase(rotateLeft(left())))
                    .map(ifLLCase(rotateRight()))
                    .orElseThrow();

        } else if (compare < 0) {

            current.right(add(current.right(), value));

            current = Optional.of(current)
                    .map(ifRLCase(rotateRight(right())))
                    .map(ifRRCase(rotateLeft()))
                    .orElseThrow();
        }

        return current;
    }

    public void remove(E value) {

        root = remove(root, value);
        root.color(Color.BLACK);
    }

    private MyTree<E> remove(MyTree<E> current, E value) {

        if (MyTrees.isNil(current)) {
            return MyTrees.nil();
        }

        int compare = MyTrees.compare(current, value);
        if (compare > 0) {

            current = Optional.of(current)
                    .map(ifBlack(left(), moveRedLeft()))
                    .orElseThrow();

            current.left(remove(current.left(), value));

            current = Optional.of(current)
                    .map(ifRCase(rotateLeft()))
                    .orElseThrow();
        } else {

            current = Optional.of(current)
                    .map(ifBlack(right(), moveRedRight()))
                    .orElseThrow();

            if (compare == 0) {

                MyTree<E> minTree = min(current.right());
                if (MyTrees.isNil(minTree)) {
                    return MyTrees.nil();
                }

                value = minTree.value();
                current.value(value);
            }

            current.right(remove(current.right(), value));

            current = Optional.of(current)
                    .map(ifLCase(rotateRight()))
                    .orElseThrow();
        }

        current = Optional.of(current)
                .map(ifHasAllRedChildren(colorFlips()))
                .orElseThrow();

        return current;
    }

    private MyTree<E> min(MyTree<E> current) {

        if (MyTrees.isNil(current.left())) {
            return current;
        }
        return min(current.left());
    }

    public E[] toArray(IntFunction<E[]> generator) {
        return MyTrees.toArray(root, generator);
    }

    @Override
    public String toString() {
        return MyTrees.toString(root);
    }
}