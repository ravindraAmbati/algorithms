package com.learn.algorithms.DepthFirstSearch;

import com.learn.algorithms.commons.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.Arrays;

class DFSImplTest {

    private String expected = null;
    private String actual = null;
    private DFS<Integer> testClassInteger = null;
    private DFS<String> testClassString = null;
    private DFS<URL> testClassUrl = null;

    @BeforeEach
    void setUp() {
        expected = null;
        actual = null;
        testClassInteger = new DFSImpl<>();
        testClassString = new DFSImpl<>();
        testClassUrl = new DFSImpl<>();
    }

    @AfterEach
    void tearDown() {
        expected = null;
        actual = null;
        testClassInteger = null;
        testClassString = null;
        testClassUrl = null;
    }

    @Test
    void dfsIntTest() {

        expected = "1 2 6 7 3 4 5 8 10 11 9 ";

        // init
        Node<Integer> integerNode1 = new Node<>(1);
        Node<Integer> integerNode2 = new Node<>(2);
        Node<Integer> integerNode3 = new Node<>(3);
        Node<Integer> integerNode4 = new Node<>(4);
        Node<Integer> integerNode5 = new Node<>(5);
        Node<Integer> integerNode6 = new Node<>(6);
        Node<Integer> integerNode7 = new Node<>(7);
        Node<Integer> integerNode8 = new Node<>(8);
        Node<Integer> integerNode9 = new Node<>(9);
        Node<Integer> integerNode10 = new Node<>(10);
        Node<Integer> integerNode11 = new Node<>(11);

        //chaining
        integerNode1.addChildren(Arrays.asList(integerNode2, integerNode3, integerNode4, integerNode5));
        integerNode2.addChildren(Arrays.asList(integerNode6, integerNode7));
        integerNode5.addChildren(Arrays.asList(integerNode8, integerNode9));
        integerNode8.addChild(integerNode10);
        integerNode10.addChild(integerNode11);
        integerNode11.addChild(integerNode1);

        actual = testClassInteger.dfs(integerNode1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void dfsStringTest() {

        expected = "R A A1 A2 B B3 B2 B1 C D E ";

        // init
        Node<String> a = new Node<>("A");
        Node<String> a1 = new Node<>("A1");
        Node<String> a2 = new Node<>("A2");
        Node<String> b = new Node<>("B");
        Node<String> b1 = new Node<>("B1");
        Node<String> b2 = new Node<>("B2");
        Node<String> b3 = new Node<>("B3");
        Node<String> r = new Node<>("R");
        Node<String> d = new Node<>("D");
        Node<String> c = new Node<>("C");
        Node<String> e = new Node<>("E");

        //chaining
        //chaining
        r.addChildren(Arrays.asList(a, b, c, d));
        a.addChildren(Arrays.asList(a1, a2));
        b.addChildren(Arrays.asList(b3, b2, b1));
        d.addChild(e);
        e.addChild(r);

        actual = testClassString.dfs(r);
        Assertions.assertEquals(expected, actual);
    }
}