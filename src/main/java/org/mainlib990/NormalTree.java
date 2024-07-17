package org.mainlib990;

class NormalTree<E> extends AbstractTree<E> {

    public NormalTree(E value) {
        super(Color.RED, value);
    }

    @Override
    public String toString() {
        return "%s : %s".formatted(value(), color());
    }
}
