package org.mainlib990;

interface MyTree<E> {

    E value();

    void value(E newValue);

    Color color();

    void color(Color newColor);

    MyTree<E> left();

    void left(MyTree<E> newLeft);

    MyTree<E> right();

    void right(MyTree<E> newRight);
}
