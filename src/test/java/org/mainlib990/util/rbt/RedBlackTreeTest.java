package org.mainlib990.util.rbt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    private RedBlackTree<Integer> redBlackTree;

    @BeforeEach
    void setUp() {
        redBlackTree = new RedBlackTree<>();
    }

    @Test
    @DisplayName("""
            add - 6, 16, 4, 8, 24, 28, 2, 5, 7, 12,
            18, 26, 36, 32, 37""")
    void givenNumbers_whenAdd_thenToBeSorted1() {

        redBlackTree.add(6);
        testSorted(redBlackTree);
        testColors(redBlackTree, "6 : BLACK");

        redBlackTree.add(16);
        testSorted(redBlackTree);
        testColors(redBlackTree, "6 : BLACK", "16 : RED");

        redBlackTree.add(4);
        testSorted(redBlackTree);
        testColors(redBlackTree, "4 : RED", "6 : BLACK", "16 : RED");

        redBlackTree.add(8);
        testSorted(redBlackTree);
        testColors(redBlackTree, "4 : BLACK",
                "6 : BLACK",
                "8 : RED",
                "16 : BLACK");

        redBlackTree.add(24);
        testSorted(redBlackTree);
        testColors(redBlackTree, "4 : BLACK",
                "6 : BLACK",
                "8 : RED",
                "16 : BLACK",
                "24 : RED");

        redBlackTree.add(28);
        testSorted(redBlackTree);
        testColors(redBlackTree, "4 : BLACK",
                "6 : BLACK",
                "8 : BLACK",
                "16 : RED",
                "24 : BLACK",
                "28 : RED");

        redBlackTree.add(2);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "6 : BLACK",
                "8 : BLACK",
                "16 : RED",
                "24 : BLACK",
                "28 : RED");

        redBlackTree.add(5);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "8 : BLACK",
                "16 : RED",
                "24 : BLACK",
                "28 : RED");

        redBlackTree.add(7);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "16 : RED",
                "24 : BLACK",
                "28 : RED");

        redBlackTree.add(12);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "12 : RED",
                "16 : RED",
                "24 : BLACK",
                "28 : RED");

        redBlackTree.add(18);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "12 : RED",
                "16 : RED",
                "18 : RED",
                "24 : BLACK",
                "28 : RED");

        redBlackTree.add(26);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : RED",
                "7 : RED",
                "8 : BLACK",
                "12 : RED",
                "16 : BLACK",
                "18 : BLACK",
                "24 : RED",
                "26 : RED",
                "28 : BLACK");

        redBlackTree.add(36);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "12 : RED",
                "16 : BLACK",
                "18 : BLACK",
                "24 : BLACK",
                "26 : RED",
                "28 : BLACK",
                "36 : RED");

        redBlackTree.add(32);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "12 : RED",
                "16 : BLACK",
                "18 : BLACK",
                "24 : BLACK",
                "26 : BLACK",
                "28 : RED",
                "32 : RED",
                "36 : BLACK");

        redBlackTree.add(37);
        testSorted(redBlackTree);
        testColors(redBlackTree,
                "2 : RED",
                "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "12 : RED",
                "16 : BLACK",
                "18 : BLACK",
                "24 : BLACK",
                "26 : BLACK",
                "28 : RED",
                "32 : RED",
                "36 : BLACK",
                "37 : RED");
    }

    @Test
    @DisplayName("add - 5, 2, 7, 0, 4, 6, 8, 1, 3, 9")
    void givenNumbers_whenAdd_thenToBeSorted2() {

        redBlackTree.add(5);
        testSorted(redBlackTree);
        testColors(redBlackTree, "5 : BLACK");

        redBlackTree.add(2);
        testSorted(redBlackTree);
        testColors(redBlackTree, "2 : RED", "5 : BLACK");

        redBlackTree.add(7);
        testSorted(redBlackTree);
        testColors(redBlackTree, "2 : RED", "5 : BLACK", "7 : RED");

        redBlackTree.add(0);
        testSorted(redBlackTree);
        testColors(redBlackTree, "0 : RED",
                "2 : BLACK",
                "5 : BLACK",
                "7 : BLACK");

        redBlackTree.add(4);
        testSorted(redBlackTree);
        testColors(redBlackTree, "0 : RED",
                "2 : BLACK",
                "4 : RED",
                "5 : BLACK",
                "7 : BLACK");

        redBlackTree.add(6);
        testSorted(redBlackTree);
        testColors(redBlackTree, "0 : RED",
                "2 : BLACK",
                "4 : RED",
                "5 : BLACK",
                "6 : RED",
                "7 : BLACK");

        redBlackTree.add(8);
        testSorted(redBlackTree);
        testColors(redBlackTree, "0 : RED",
                "2 : BLACK",
                "4 : RED",
                "5 : BLACK",
                "6 : RED",
                "7 : BLACK",
                "8 : RED");

        redBlackTree.add(1);
        testSorted(redBlackTree);
        testColors(redBlackTree, "0 : BLACK",
                "1 : RED",
                "2 : RED",
                "4 : BLACK",
                "5 : BLACK",
                "6 : RED",
                "7 : BLACK",
                "8 : RED");

        redBlackTree.add(3);
        testSorted(redBlackTree);
        testColors(redBlackTree, "0 : BLACK",
                "1 : RED",
                "2 : RED",
                "3 : RED",
                "4 : BLACK",
                "5 : BLACK",
                "6 : RED",
                "7 : BLACK",
                "8 : RED");

        redBlackTree.add(9);
        testSorted(redBlackTree);
        testColors(redBlackTree, "0 : BLACK",
                "1 : RED",
                "2 : RED",
                "3 : RED",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "9 : RED");
    }

    @Test
    @DisplayName("""
            add - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31""")
    void givenNumbers_whenAdd_thenToBeSorted3() {

        redBlackTree.add(1);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK");

        redBlackTree.add(2);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK", "2 : RED");

        redBlackTree.add(3);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : RED", "2 : BLACK", "3 : RED");

        redBlackTree.add(4);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : RED");

        redBlackTree.add(5);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : RED",
                "4 : BLACK",
                "5 : RED");

        redBlackTree.add(6);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : RED",
                "5 : BLACK",
                "6 : RED");

        redBlackTree.add(7);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : RED",
                "5 : RED",
                "6 : BLACK",
                "7 : RED");

        redBlackTree.add(8);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : RED",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : RED",
                "7 : BLACK",
                "8 : RED");

        redBlackTree.add(9);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "9 : RED");

        redBlackTree.add(10);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : RED");

        redBlackTree.add(11);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : RED",
                "10 : BLACK",
                "11 : RED");

        redBlackTree.add(12);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : RED",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : RED",
                "11 : BLACK",
                "12 : RED");

        redBlackTree.add(13);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : BLACK",
                "11 : RED",
                "12 : BLACK",
                "13 : RED");

        redBlackTree.add(14);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : RED");

        redBlackTree.add(15);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : RED",
                "14 : BLACK",
                "15 : RED");

        redBlackTree.add(16);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : RED",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : RED",
                "15 : BLACK",
                "16 : RED");

        redBlackTree.add(17);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : RED",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : BLACK",
                "15 : RED",
                "16 : BLACK",
                "17 : RED");

        redBlackTree.add(18);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : RED");

        redBlackTree.add(19);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : RED",
                "18 : BLACK",
                "19 : RED");

        redBlackTree.add(20);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : RED",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : RED",
                "19 : BLACK",
                "20 : RED");

        redBlackTree.add(21);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : RED",
                "20 : BLACK",
                "21 : RED");

        redBlackTree.add(22);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : RED",
                "21 : BLACK",
                "22 : RED");

        redBlackTree.add(23);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : RED",
                "21 : RED",
                "22 : BLACK",
                "23 : RED");

        redBlackTree.add(24);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : RED",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : RED",
                "23 : BLACK",
                "24 : RED");

        redBlackTree.add(25);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : RED",
                "21 : BLACK",
                "22 : BLACK",
                "23 : RED",
                "24 : BLACK",
                "25 : RED");

        redBlackTree.add(26);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : RED");

        redBlackTree.add(27);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : RED",
                "26 : BLACK",
                "27 : RED");

        redBlackTree.add(28);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : RED",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : RED",
                "27 : BLACK",
                "28 : RED");

        redBlackTree.add(29);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : RED",
                "28 : BLACK",
                "29 : RED");

        redBlackTree.add(30);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : BLACK",
                "30 : RED");

        redBlackTree.add(31);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK",
                "2 : BLACK",
                "3 : BLACK",
                "4 : BLACK",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");
    }

    @Test
    @DisplayName("add - 1, 3, 2")
    void givenNumbers_whenAdd_thenToBeSorted4() {

        redBlackTree.add(1);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK");

        redBlackTree.add(3);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : BLACK", "3 : RED");

        redBlackTree.add(2);
        testSorted(redBlackTree);
        testColors(redBlackTree, "1 : RED", "2 : BLACK", "3 : RED");
    }

    @Test
    @DisplayName("""
            delete - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31""")
    void givenSortedNumbers_whenRemoveNumbers_thenToBeDeleted() {

        initRedBlackTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31);

        redBlackTree.remove(1);
        testSorted(redBlackTree);
        testColors(redBlackTree, "2 : BLACK",
                "3 : RED",
                "4 : BLACK",
                "5 : BLACK",
                "6 : RED",
                "7 : BLACK",
                "8 : BLACK",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(2);
        testSorted(redBlackTree);
        testColors(redBlackTree, "3 : BLACK",
                "4 : RED",
                "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(3);
        testSorted(redBlackTree);
        testColors(redBlackTree, "4 : BLACK",
                "5 : RED",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(4);
        testSorted(redBlackTree);
        testColors(redBlackTree, "5 : BLACK",
                "6 : BLACK",
                "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(5);
        testSorted(redBlackTree);
        testColors(redBlackTree, "6 : BLACK",
                "7 : RED",
                "8 : BLACK",
                "9 : BLACK",
                "10 : RED",
                "11 : BLACK",
                "12 : BLACK",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(6);
        testSorted(redBlackTree);
        testColors(redBlackTree, "7 : BLACK",
                "8 : RED",
                "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(7);
        testSorted(redBlackTree);
        testColors(redBlackTree, "8 : BLACK",
                "9 : RED",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(8);
        testSorted(redBlackTree);
        testColors(redBlackTree, "9 : BLACK",
                "10 : BLACK",
                "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(9);
        testSorted(redBlackTree);
        testColors(redBlackTree, "10 : BLACK",
                "11 : RED",
                "12 : BLACK",
                "13 : BLACK",
                "14 : RED",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(10);
        testSorted(redBlackTree);
        testColors(redBlackTree, "11 : BLACK",
                "12 : RED",
                "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(11);
        testSorted(redBlackTree);
        testColors(redBlackTree, "12 : BLACK",
                "13 : RED",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(12);
        testSorted(redBlackTree);
        testColors(redBlackTree, "13 : BLACK",
                "14 : BLACK",
                "15 : BLACK",
                "16 : BLACK",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(13);
        testSorted(redBlackTree);
        testColors(redBlackTree, "14 : BLACK",
                "15 : RED",
                "16 : BLACK",
                "17 : BLACK",
                "18 : RED",
                "19 : BLACK",
                "20 : BLACK",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : RED",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(14);
        testSorted(redBlackTree);
        testColors(redBlackTree, "15 : BLACK",
                "16 : RED",
                "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : RED",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(15);
        testSorted(redBlackTree);
        testColors(redBlackTree, "16 : BLACK",
                "17 : RED",
                "18 : BLACK",
                "19 : BLACK",
                "20 : RED",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(16);
        testSorted(redBlackTree);
        testColors(redBlackTree, "17 : BLACK",
                "18 : BLACK",
                "19 : BLACK",
                "20 : RED",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(17);
        testSorted(redBlackTree);
        testColors(redBlackTree, "18 : BLACK",
                "19 : RED",
                "20 : BLACK",
                "21 : BLACK",
                "22 : RED",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(18);
        testSorted(redBlackTree);
        testColors(redBlackTree, "19 : BLACK",
                "20 : RED",
                "21 : BLACK",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(19);
        testSorted(redBlackTree);
        testColors(redBlackTree, "20 : BLACK",
                "21 : RED",
                "22 : BLACK",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(20);
        testSorted(redBlackTree);
        testColors(redBlackTree, "21 : BLACK",
                "22 : RED",
                "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : BLACK",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(21);
        testSorted(redBlackTree);
        testColors(redBlackTree, "22 : BLACK",
                "23 : RED",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : BLACK",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(22);
        testSorted(redBlackTree);
        testColors(redBlackTree, "23 : BLACK",
                "24 : BLACK",
                "25 : BLACK",
                "26 : BLACK",
                "27 : BLACK",
                "28 : BLACK",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(23);
        testSorted(redBlackTree);
        testColors(redBlackTree, "24 : BLACK",
                "25 : RED",
                "26 : BLACK",
                "27 : BLACK",
                "28 : RED",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(24);
        testSorted(redBlackTree);
        testColors(redBlackTree, "25 : BLACK",
                "26 : RED",
                "27 : BLACK",
                "28 : BLACK",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(25);
        testSorted(redBlackTree);
        testColors(redBlackTree, "26 : BLACK",
                "27 : RED",
                "28 : BLACK",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(26);
        testSorted(redBlackTree);
        testColors(redBlackTree, "27 : BLACK",
                "28 : BLACK",
                "29 : RED",
                "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(27);
        testSorted(redBlackTree);
        testColors(redBlackTree, "28 : BLACK",
                "29 : RED",
                "30 : BLACK",
                "31 : BLACK");

        redBlackTree.remove(28);
        testSorted(redBlackTree);
        testColors(redBlackTree, "29 : BLACK",
                "30 : BLACK",
                "31 : BLACK");

        redBlackTree.remove(29);
        testSorted(redBlackTree);
        testColors(redBlackTree, "30 : BLACK",
                "31 : RED");

        redBlackTree.remove(30);
        testSorted(redBlackTree);
        testColors(redBlackTree, "31 : BLACK");

        redBlackTree.remove(31);
        testSorted(redBlackTree);
        testColors(redBlackTree);
    }

    private void initRedBlackTree(int... numbers) {

        for (int number : numbers) {
            redBlackTree.add(number);
        }
    }

    private void testSorted(RedBlackTree<Integer> tree) {

        Integer[] actual = tree.toArray(Integer[]::new);
        Integer[] expected = Arrays.stream(actual)
                .sorted(Comparator.naturalOrder())
                .toArray(Integer[]::new);

        assertArrayEquals(expected, actual);
    }

    private void testColors(RedBlackTree<Integer> tree, String... expectedColors) {

        String[] treeStrings = tree.toString().split(System.lineSeparator());

        for (String expectedColor : expectedColors) {

            boolean match = Arrays.asList(treeStrings).contains(expectedColor);
            assertTrue(match, () -> "expected color is not included : \"%s\"".formatted(expectedColor));
        }
    }
}
