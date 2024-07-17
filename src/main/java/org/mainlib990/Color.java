package org.mainlib990;

enum Color {

    RED {

        @Override
        Color invert() {
            return BLACK;
        }},

    BLACK {

        @Override
        Color invert() {
            return RED;
        }
    };

    abstract Color invert();
}
