package com.learn.algorithms.ShortestPath;

import com.learn.algorithms.ShortestPath.common.Edge;
import com.learn.algorithms.ShortestPath.common.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BellmanFordTest {

    private List<Node> expected;
    private List<Node> actual;
    private ShortestPath testClass;

    @BeforeEach
    void setUp() {
        testClass = new BellmanFord();
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

        Edge A_B = new Edge(A, B, 1);
        Edge A_C = new Edge(A, C, 4);
        Edge A_D = new Edge(A, D, 5);
        Edge A_E = new Edge(A, E, 3);
        Edge B_C = new Edge(B, C, 1);
        Edge C_D = new Edge(C, D, 1);
        Edge B_E = new Edge(B, E, 1);

        List<Edge> edges = Arrays.asList(A_B, A_C, A_D, A_E, B_C, B_E, C_D);

        A.addNeighbours(A_B);
        A.addNeighbours(A_C);
        A.addNeighbours(A_D);
        A.addNeighbours(A_E);
        B.addNeighbours(B_C);
        B.addNeighbours(B_E);
        C.addNeighbours(C_D);

        List<Node> nodes = Arrays.asList(A, B, C, D, E);

        expected = Arrays.asList(A, B, C);
        actual = testClass.computeShortestPath(nodes, edges, C);

        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(A, B, C, D);
        actual = testClass.computeShortestPath(nodes, edges, D);

        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(A, B, E);
        actual = testClass.computeShortestPath(nodes, edges, E);

        Assertions.assertEquals(expected, actual);
    }
}