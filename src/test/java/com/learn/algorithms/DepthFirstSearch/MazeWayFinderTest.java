package com.learn.algorithms.DepthFirstSearch;

import com.learn.algorithms.utility.MazeFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazeWayFinderTest {

    private DFS<String> testClass;
    private MazeFileReader mazeFileReader;

    @BeforeEach
    void setUp() {
        testClass = new MazeWayFinder<>();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void findOutMazeWay() {
        mazeFileReader = new MazeFileReader("5_x_5.maze", 5, 5);
        mazeFileReader.parse();
        testClass.findOutMazeWay(mazeFileReader);
    }

    @Test
    void findOutMazeWay2() {
        mazeFileReader = new MazeFileReader("7_x_7.maze", 7, 7);
        mazeFileReader.parse();
        testClass.findOutMazeWay(mazeFileReader);
    }
}