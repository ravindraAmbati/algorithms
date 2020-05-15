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
    void dfs() {

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
        build.addNeighbours(test);
        test.addNeighbours(testClasses);
        testClasses.addNeighbours(processTestResources);
        processTestResources.addNeighbours(compileTestJava);
        compileTestJava.addNeighbours(classes);
        classes.addNeighbours(processResources);
        processResources.addNeighbours(compileJava);
        compileJava.addNeighbours(clean);

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

        actual = testClass.dfs(nodes);
        Assertions.assertEquals(expected, actual);
    }
}