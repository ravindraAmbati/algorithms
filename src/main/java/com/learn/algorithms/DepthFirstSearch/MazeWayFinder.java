package com.learn.algorithms.DepthFirstSearch;

/* @author ravin @date 15-05-2020 @time 19:31 */

import com.learn.algorithms.commons.Node;
import com.learn.algorithms.utility.MazeFileReader;

import java.util.List;

public class MazeWayFinder<T> implements DFS<T> {

    private static final String FOUND = "Found Exit!!!";
    private static final String NOT_FOUND = "NO Exit!!!";
    private int[][] map = null;
    private int end = 0;
    private boolean[][] visited = null;

    @Override
    public String dfs(Node<T> root) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    @Override
    public String topologicalOrdering(List<Node<T>> nodes) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    @Override
    public String detectCycle(List<Node<T>> nodes) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    @Override
    public String findOutMazeWay(MazeFileReader mazeFileReader) {

        this.map = mazeFileReader.getMap();
        end = this.map.length;
        this.visited = new boolean[end][end];
        try {
            passThru(mazeFileReader.getStartingPositionRow(), mazeFileReader.getStartingPositionCol(), "Start");
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return NOT_FOUND;
    }

    private void passThru(int r, int c, String direction) {
        if (2 == map[r][c]) {
            System.out.println(direction + " at row: " + r + " at col: " + c + " ");
        }
        if (3 == map[r][c]) {
            System.out.println(direction + " at row: " + r + " at col: " + c + " ");
            System.out.println("End");
            throw new RuntimeException(FOUND);
        }
        if (this.visited[r][c]) {
            return;
        }
        if (1 == map[r][c]) {
            return;
        }
        if (r < 0 || r > end || c < 0 || c > end) {
            return;
        }
        if (0 == map[r][c]) {
            System.out.println(direction + " at row: " + r + " at col: " + c + " ");
        }
        this.visited[r][c] = true;
        //up
        passThru(r - 1, c, "up");
        //right
        passThru(r, c + 1, "right");
        //left
        passThru(r, c - 1, "left");
        //down
        passThru(r + 1, c, "down");
    }
}
