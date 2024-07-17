package org.mainlib990.util.rbt;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

final class MyTreeOperators {

    private MyTreeOperators() {
    }

    static <T> Predicate<MyTree<T>> isNotNil() {
        return tree -> !MyTrees.isNil(tree);
    }

    static <T> Supplier<MyTree<T>> newNormal(T value) {
        return () -> MyTrees.newNormal(value);
    }

    static <T> Supplier<MyTree<T>> nil() {
        return MyTrees::nil;
    }

    static <T> UnaryOperator<MyTree<T>> ifAllRedChildren(UnaryOperator<MyTree<T>> operator) {
        return ifCase(MyTrees::hasAllRedChildren, operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifLRCase(UnaryOperator<MyTree<T>> operator) {
        return ifCase(MyTrees::isLRCase, operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifLLCase(UnaryOperator<MyTree<T>> operator) {
        return ifCase(MyTrees::isLLCase, operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifRLCase(UnaryOperator<MyTree<T>> operator) {
        return ifCase(MyTrees::isRLCase, operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifRRCase(UnaryOperator<MyTree<T>> operator) {
        return ifCase(MyTrees::isRRCase, operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifLCase(UnaryOperator<MyTree<T>> operator) {
        return ifCase(MyTrees::isLCase, operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifRCase(UnaryOperator<MyTree<T>> operator) {
        return ifCase(MyTrees::isRCase, operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifLeftIsBlack(UnaryOperator<MyTree<T>> operator) {
        return ifCase(tree -> MyTrees.isBlack(tree.left()), operator);
    }

    static <T> UnaryOperator<MyTree<T>> ifRightIsBlack(UnaryOperator<MyTree<T>> operator) {
        return ifCase(tree -> MyTrees.isBlack(tree.right()), operator);
    }

    private static <T> UnaryOperator<MyTree<T>> ifCase(Predicate<MyTree<T>> predicate,
                                                       UnaryOperator<MyTree<T>> operator) {

        return tree -> {

            if (predicate.test(tree)) {
                return operator.apply(tree);
            }
            return tree;
        };
    }
    static <T> UnaryOperator<MyTree<T>> leftChildTo(UnaryOperator<MyTree<T>> operator) {

        return tree -> {

            tree.left(operator.apply(tree.left()));
            return tree;
        };
    }

    static <T> UnaryOperator<MyTree<T>> rightChildTo(UnaryOperator<MyTree<T>> operator) {

        return tree -> {

            tree.right(operator.apply(tree.right()));
            return tree;
        };
    }

    static <T> UnaryOperator<MyTree<T>> colorFlips() {

        return tree -> {

            MyTrees.colorFlips(tree);
            return tree;
        };
    }

    static <T> UnaryOperator<MyTree<T>> rotateLeft() {
        return MyTrees::rotateLeft;
    }

    static <T> UnaryOperator<MyTree<T>> rotateRight() {
        return MyTrees::rotateRight;
    }

    static <T> UnaryOperator<MyTree<T>> moveRedLeft() {
        return MyTrees::moveRedLeft;
    }

    static <T> UnaryOperator<MyTree<T>> moveRedRight() {
        return MyTrees::moveRedRight;
    }
}
