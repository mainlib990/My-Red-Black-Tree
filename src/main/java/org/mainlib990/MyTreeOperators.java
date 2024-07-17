package org.mainlib990;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

final class MyTreeOperators {

    private MyTreeOperators() {
    }

    static <T> UnaryOperator<MyTree<T>> ifHasAllRedChildren(UnaryOperator<MyTree<T>> operator) {
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

    static <T> UnaryOperator<MyTree<T>> ifBlack(UnaryOperator<MyTree<T>> operator1,
                                                UnaryOperator<MyTree<T>> operator2) {
        return ifCase(tree -> MyTrees.isBlack(operator1.apply(tree)), operator2);
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

    static <T> UnaryOperator<MyTree<T>> left() {
        return MyTree::left;
    }

    static <T> UnaryOperator<MyTree<T>> right() {
        return MyTree::right;
    }

    static <T> UnaryOperator<MyTree<T>> colorFlips() {
        return colorFlips(UnaryOperator.identity());
    }

    static <T> UnaryOperator<MyTree<T>> colorFlips(UnaryOperator<MyTree<T>> operator) {

        return tree -> {

            MyTrees.colorFlips(operator.apply(tree));
            return tree;
        };
    }

    static <T> UnaryOperator<MyTree<T>> rotateLeft() {
        return rotateLeft(UnaryOperator.identity());
    }

    static <T> UnaryOperator<MyTree<T>> rotateLeft(UnaryOperator<MyTree<T>> operator) {
        return tree -> MyTrees.rotateLeft(operator.apply(tree));
    }

    static <T> UnaryOperator<MyTree<T>> rotateRight() {
        return rotateRight(UnaryOperator.identity());
    }

    static <T> UnaryOperator<MyTree<T>> rotateRight(UnaryOperator<MyTree<T>> operator) {
        return tree -> MyTrees.rotateRight(operator.apply(tree));
    }

    static <T> UnaryOperator<MyTree<T>> moveRedLeft() {
        return MyTrees::moveRedLeft;
    }

    static <T> UnaryOperator<MyTree<T>> moveRedRight() {
        return MyTrees::moveRedRight;
    }
}
