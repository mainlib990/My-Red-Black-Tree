package org.mainlib990.util.rbt;

import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;

final class MyTrees {

    @SuppressWarnings("rawtypes")
    private static final MyTree NIL = new NilTree();

    private MyTrees() {
    }

    @SuppressWarnings("unchecked")
    static <E> MyTree<E> nil() {
        return NIL;
    }

    static <E> MyTree<E> newNormal(E value) {
        return new NormalTree<>(value);
    }

    static boolean isNil(MyTree<?> tree) {
        return tree == NIL;
    }

    static boolean isRed(MyTree<?> tree) {
        return tree.color() == Color.RED;
    }

    static boolean isBlack(MyTree<?> tree) {
        return tree.color() == Color.BLACK;
    }

    static boolean hasAllRedChildren(MyTree<?> tree) {
        return isRed(tree.left()) && isRed(tree.right());
    }

    static boolean hasAllBlackChildren(MyTree<?> tree) {
        return isBlack(tree.left()) && isBlack(tree.right());
    }

    static boolean isLRCase(MyTree<?> tree) {
        return isRed(tree.left()) && isRed(tree.left().right());
    }

    static boolean isLLCase(MyTree<?> tree) {
        return isRed(tree.left()) && isRed(tree.left().left());
    }

    static boolean isRLCase(MyTree<?> tree) {
        return isRed(tree.right()) && isRed(tree.right().left());
    }

    static boolean isRRCase(MyTree<?> tree) {
        return isRed(tree.right()) && isRed(tree.right().right());
    }

    static boolean isLCase(MyTree<?> tree) {
        return isLRCase(tree) || isLLCase(tree);
    }

    static boolean isRCase(MyTree<?> tree) {
        return isRLCase(tree) || isRRCase(tree);
    }

    static void colorFlips(MyTree<?> tree) {

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

    private static void swapColors(MyTree<?> t1, MyTree<?> t2) {

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

    static <E> MyTree<E> min(MyTree<E> current) {

        if (MyTrees.isNil(current.left())) {
            return current;
        }
        return min(current.left());
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

    static String toString(MyTree<?> root) {

        StringBuilder builder = new StringBuilder();

        toString(root, builder);

        return builder.toString();
    }

    private static void toString(MyTree<?> current, StringBuilder builder) {

        if (isNil(current)) {

            builder.append(current).append(System.lineSeparator());
            return;
        }

        toString(current.left(), builder);

        builder.append(current).append(System.lineSeparator());

        toString(current.right(), builder);
    }

    static final class NilTree<E> extends MyTree<E> {

        NilTree() {
            super(Color.BLACK);
        }

        @Override
        public E value() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void value(E newValue) {
            throw new UnsupportedOperationException(newValue.toString());
        }

        @Override
        public void color(Color newColor) {
            // No-op
        }

        @Override
        public MyTree<E> left() {
            return this;
        }

        @Override
        public void left(MyTree<E> newLeft) {
            throw new UnsupportedOperationException(newLeft.toString());
        }

        @Override
        public MyTree<E> right() {
            return this;
        }

        @Override
        public void right(MyTree<E> newRight) {
            throw new UnsupportedOperationException(newRight.toString());
        }

        @Override
        public String toString() {
            return "NIL";
        }
    }
}
