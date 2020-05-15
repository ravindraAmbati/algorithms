package com.learn.algorithms.DepthFirstSearch;

import com.learn.algorithms.commons.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CycleDetectionTest {

    private String expected = null;
    private String actual = null;
    private DFS<String> testClass = null;


    @BeforeEach
    void setUp() {
        expected = null;
        actual = null;
        testClass = new CycleDetection<>();
    }

    @AfterEach
    void tearDown() {
        expected = null;
        actual = null;
        testClass = null;
    }

    @Test
    void detectCycleTest() {

        expected = "R | D | R | R | B | B1 | B2 | B | A | R | A1 | ";

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
        r.addChildren(Arrays.asList(a, b, c, d));
        a.addChildren(Arrays.asList(a1, a2));
        b.addChildren(Arrays.asList(b3, b2, b1));
        d.addChild(e);
        e.addChild(r);
        c.addChild(r);
        b3.addChild(b);
        a2.addChild(r);

        actual = testClass.detectCycle(Arrays.asList(r, a, b, c, d, a1, a2, b3, b2, b1, e));
        Assertions.assertEquals(expected, actual);
    }
}