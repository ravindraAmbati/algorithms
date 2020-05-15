package com.learn.algorithms.utility;

/* @author ravin @date 15-05-2020 @time 18:50 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class MazeFileReader {

    private String fileName;
    private int noOfRows;
    private int noOfCols;
    private int[][] map;
    private int startingPositionRow;
    private int startingPositionCol;

    public MazeFileReader(String fileName, int noOfRows, int noOfCols) {
        this.fileName = fileName;
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.map = new int[noOfRows][noOfCols];
    }

    public int[][] getMap() {
        return map;
    }

    public void parse() {
        try {
            Scanner scanner = new Scanner(new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName)).getFile()));
            for (int i = 0; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    map[i][j] = scanner.nextInt();
                    if (2 == map[i][j]) {
                        startingPositionRow = i;
                        startingPositionCol = j;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getStartingPositionCol() {
        return startingPositionCol;
    }

    public int getStartingPositionRow() {
        return startingPositionRow;
    }

}
