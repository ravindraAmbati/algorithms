package com.learn.algorithms.ShortestPath;

import com.learn.algorithms.ShortestPath.common.Edge;
import com.learn.algorithms.ShortestPath.common.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DijkstraTest {

    private List<Node> expected;
    private List<Node> actual;
    private Dijkstra testClass;

    @BeforeEach
    void setUp() {
        testClass = new Dijkstra();
        expected = null;
        actual = null;
    }

    @AfterEach
    void tearDown() {
        testClass = null;
        expected = null;
        actual = null;
    }

    @Test
    void getShortestPathTo() {

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.addNeighbours(new Edge(A, B, 1));
        A.addNeighbours(new Edge(A, C, 4));
        A.addNeighbours(new Edge(A, D, 5));
        A.addNeighbours(new Edge(A, E, 3));
        B.addNeighbours(new Edge(B, C, 1));
        C.addNeighbours(new Edge(C, D, 1));
        B.addNeighbours(new Edge(B, E, 1));

        expected = Arrays.asList(A, B, C);
        actual = testClass.computeShortestPath(A, C);

        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(A, B, C, D);
        actual = testClass.computeShortestPath(A, D);

        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(A, B, E);
        actual = testClass.computeShortestPath(A, E);

        Assertions.assertEquals(expected, actual);
    }
}