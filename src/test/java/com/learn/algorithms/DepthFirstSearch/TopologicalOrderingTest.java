package com.learn.algorithms.DepthFirstSearch;

import com.learn.algorithms.commons.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TopologicalOrderingTest {

    private String expected = null;
    private String actual = null;
    private DFS<String> testClass = null;


    @BeforeEach
    void setUp() {
        expected = null;
        actual = null;
        testClass = new TopologicalOrdering<>();
    }

    @AfterEach
    void tearDown() {
        expected = null;
        actual = null;
        testClass = null;
    }

    @Test
    void topologicalOrdering() {

        expected = "build -> test -> testClasses -> processTestResources -> compileTestJava -> classes -> processResources -> compileJava -> clean -> ";

        // init
        Node<String> clean = new Node<>("clean");
        Node<String> compileJava = new Node<>("compileJava");
        Node<String> processResources = new Node<>("processResources");
        Node<String> classes = new Node<>("classes");
        Node<String> compileTestJava = new Node<>("compileTestJava");
        Node<String> processTestResources = new Node<>("processTestResources");
        Node<String> testClasses = new Node<>("testClasses");
        Node<String> test = new Node<>("test");
        Node<String> build = new Node<>("build");

        //chaining
        build.addChild(test);
        test.addChild(testClasses);
        testClasses.addChild(processTestResources);
        processTestResources.addChild(compileTestJava);
        compileTestJava.addChild(classes);
        classes.addChild(processResources);
        processResources.addChild(compileJava);
        compileJava.addChild(clean);

        List<Node<String>> nodes = new ArrayList<>();

        nodes.add(compileJava);
        nodes.add(testClasses);
        nodes.add(compileTestJava);
        nodes.add(processResources);
        nodes.add(classes);
        nodes.add(test);
        nodes.add(build);
        nodes.add(clean);
        nodes.add(processTestResources);

        actual = testClass.topologicalOrdering(nodes);
        Assertions.assertEquals(expected, actual);
    }
}