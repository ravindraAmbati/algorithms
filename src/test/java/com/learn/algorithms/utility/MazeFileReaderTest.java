package com.learn.algorithms.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MazeFileReaderTest {

    @Test
    void parseTest() {
        MazeFileReader mazeFileReader = new MazeFileReader("5_x_5.maze", 5, 5);
        mazeFileReader.parse();
        Assertions.assertNotNull(mazeFileReader.getMap());
        System.out.println(Arrays.deepToString(mazeFileReader.getMap()));
    }

    @Test
    void parse2Test() {
        MazeFileReader mazeFileReader = new MazeFileReader("7_x_7.maze", 7, 7);
        mazeFileReader.parse();
        Assertions.assertNotNull(mazeFileReader.getMap());
        System.out.println(Arrays.deepToString(mazeFileReader.getMap()));
    }
}