package org.mainlib990.util.rbt;

final class NormalTree<E> extends MyTree<E> {

    NormalTree(E value) {
        super(Color.RED, value);
    }

    @Override
    public String toString() {
        return "%s : %s".formatted(value(), color());
    }
}
