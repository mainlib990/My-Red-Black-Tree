package org.mainlib990;

import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;

final class MyTrees {

    @SuppressWarnings("rawtypes")
    private static final MyTree NIL = new NilTree();

    private MyTrees() {
    }

    static <E> MyTree<E> nil() {

        @SuppressWarnings("unchecked")
        MyTree<E> nil = NIL;

        return nil;
    }

    static <E> MyTree<E> newNormal(E value) {
        return new NormalTree<>(value);
    }

    static <E> boolean isNil(MyTree<E> tree) {
        return tree == NIL;
    }

    static <E> boolean isRed(MyTree<E> tree) {
        return tree.color() == Color.RED;
    }

    static <E> boolean isBlack(MyTree<E> tree) {
        return tree.color() == Color.BLACK;
    }

    static <E> boolean hasAllRedChildren(MyTree<E> tree) {
        return isRed(tree.left()) && isRed(tree.right());
    }

    static <E> boolean hasAllBlackChildren(MyTree<E> tree) {
        return isBlack(tree.left()) && isBlack(tree.right());
    }

    static <E extends Comparable<E>> int compare(MyTree<E> tree, E value) {
        return tree.value().compareTo(value);
    }

    static <E> boolean isLRCase(MyTree<E> tree) {
        return isRed(tree.left()) && isRed(tree.left().right());
    }

    static <E> boolean isLLCase(MyTree<E> tree) {
        return isRed(tree.left()) && isRed(tree.left().left());
    }

    static <E> boolean isRLCase(MyTree<E> tree) {
        return isRed(tree.right()) && isRed(tree.right().left());
    }

    static <E> boolean isRRCase(MyTree<E> tree) {
        return isRed(tree.right()) && isRed(tree.right().right());
    }

    static <E> boolean isLCase(MyTree<E> tree) {
        return isLRCase(tree) || isLLCase(tree);
    }

    static <E> boolean isRCase(MyTree<E> tree) {
        return isRLCase(tree) || isRRCase(tree);
    }

    static <E> void colorFlips(MyTree<E> tree) {

        tree.color(tree.color().invert());
        tree.left().color(tree.left().color().invert());
        tree.right().color(tree.right().color().invert());
    }

    static <E> MyTree<E> rotateLeft(MyTree<E> tree) {

        MyTree<E> right = tree.right();
        tree.right(right.left());
        right.left(tree);

        swapColors(tree, right);

        return right;
    }

    static <E> MyTree<E> rotateRight(MyTree<E> tree) {

        MyTree<E> left = tree.left();
        tree.left(left.right());
        left.right(tree);

        swapColors(tree, left);

        return left;
    }

    private static <E> void swapColors(MyTree<E> t1, MyTree<E> t2) {

        Color tmpColor = t1.color();
        t1.color(t2.color());
        t2.color(tmpColor);
    }

    static <E> MyTree<E> moveRedLeft(MyTree<E> tree) {

        if (isRed(tree.right())) {
            tree = rotateLeft(tree);
        } else if (hasAllBlackChildren(tree.left())) {
            colorFlips(tree);
        }
        return tree;
    }

    static <E> MyTree<E> moveRedRight(MyTree<E> tree) {

        if (isRed(tree.left())) {
            tree = rotateRight(tree);
        } else if (hasAllBlackChildren(tree.right())) {
            colorFlips(tree);
        }
        return tree;
    }

    static <E> E[] toArray(MyTree<E> root, IntFunction<E[]> generator) {

        List<E> sortedNumbers = new LinkedList<>();

        toArray(root, sortedNumbers);

        return sortedNumbers.toArray(generator);
    }

    private static <E> void toArray(MyTree<E> current, List<E> result) {

        if (isNil(current)) {
            return;
        }

        toArray(current.left(), result);

        result.add(current.value());

        toArray(current.right(), result);
    }

    static <E> String toString(MyTree<E> root) {

        StringBuilder builder = new StringBuilder();

        toString(root, builder);

        return builder.toString();
    }

    private static <E> void toString(MyTree<E> current, StringBuilder builder) {

        if (isNil(current)) {

            builder.append(current).append(System.lineSeparator());
            return;
        }

        toString(current.left(), builder);

        builder.append(current).append(System.lineSeparator());

        toString(current.right(), builder);
    }

    private static class NilTree<E> extends AbstractTree<E> {

        public NilTree() {
            super(Color.BLACK);
        }

        @Override
        public E value() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void value(E newValue) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void color(Color newColor) {
            // Noop
        }

        @Override
        public MyTree<E> left() {
            return this;
        }

        @Override
        public void left(MyTree<E> newLeft) {
            throw new UnsupportedOperationException();
        }

        @Override
        public MyTree<E> right() {
            return this;
        }

        @Override
        public void right(MyTree<E> newRight) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String toString() {
            return "NIL";
        }
    }
}
