package com.learn.algorithms.ShortestPath;

import com.learn.algorithms.ShortestPath.common.Edge;
import com.learn.algorithms.ShortestPath.common.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DijkstraTest {

    private Dijkstra testClass;

    @BeforeEach
    void setUp() {
        testClass = new Dijkstra();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void getShortestPathTo() {

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");

        A.addNeighbours(new Edge(A, B, 1));
        A.addNeighbours(new Edge(A, C, 4));
        B.addNeighbours(new Edge(B, C, 1));

        System.out.println(testClass.computeShortestPath(A, C));
    }
}