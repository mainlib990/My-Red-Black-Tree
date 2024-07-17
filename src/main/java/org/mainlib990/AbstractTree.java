package org.mainlib990;

class AbstractTree<E> implements MyTree<E> {

    private E value;
    private Color color;
    private MyTree<E> left;
    private MyTree<E> right;

    private AbstractTree() {

        this.left = MyTrees.nil();
        this.right = MyTrees.nil();
    }

    protected AbstractTree(Color color) {

        this();
        this.color = color;
    }

    protected AbstractTree(Color color, E value) {

        this(color);
        this.value = value;
    }

    @Override
    public E value() {
        return this.value;
    }

    @Override
    public void value(E newValue) {
        this.value = newValue;
    }

    @Override
    public Color color() {
        return this.color;
    }

    @Override
    public void color(Color newColor) {
        this.color = newColor;
    }

    @Override
    public MyTree<E> left() {
        return this.left;
    }

    @Override
    public void left(MyTree<E> newLeft) {
        this.left = newLeft;
    }

    @Override
    public MyTree<E> right() {
        return right;
    }

    @Override
    public void right(MyTree<E> newRight) {
        this.right = newRight;
    }
}
