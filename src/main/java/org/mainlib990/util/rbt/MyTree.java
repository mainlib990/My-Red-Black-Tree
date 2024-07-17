package org.mainlib990.util.rbt;

sealed class MyTree<E> permits MyTrees.NilTree, NormalTree {

    private E value;
    private Color color;
    private MyTree<E> left;
    private MyTree<E> right;

    private MyTree() {

        this.left = MyTrees.nil();
        this.right = MyTrees.nil();
    }

    protected MyTree(Color color) {

        this();
        this.color = color;
    }

    protected MyTree(Color color, E value) {

        this(color);
        this.value = value;
    }

    public E value() {
        return this.value;
    }

    public void value(E newValue) {
        this.value = newValue;
    }

    public Color color() {
        return this.color;
    }

    public void color(Color newColor) {
        this.color = newColor;
    }

    public MyTree<E> left() {
        return this.left;
    }

    public void left(MyTree<E> newLeft) {
        this.left = newLeft;
    }

    public MyTree<E> right() {
        return right;
    }

    public void right(MyTree<E> newRight) {
        this.right = newRight;
    }
}
