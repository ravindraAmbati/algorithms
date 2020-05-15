package com.learn.algorithms.DepthFirstSearch;

/* @author ravin @date 15-05-2020 @time 13:29 */

import com.learn.algorithms.commons.Node;
import com.learn.algorithms.utility.MazeFileReader;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering<T> implements DFS<T> {

    private static final String DELIMITER = " -> ";
    private Stack<Node<T>> stack = null;

    @Override
    public String dfs(Node<T> root) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    private void topologicalOrdering(Node<T> root) {

        root.setVisited(true);
        List<Node<T>> children = root.getChildren();
        for (Node<T> node : children) {
            if (!node.isVisited()) {
                topologicalOrdering(node);
            }
        }
        stack.push(root);
    }

    @Override
    public String topologicalOrdering(List<Node<T>> nodes) {

        stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (Node<T> node : nodes) {
            if (!node.isVisited()) {
                topologicalOrdering(node);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop().getValue()).append(DELIMITER);
        }
        return result.toString();
    }

    @Override
    public String detectCycle(List<Node<T>> nodes) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    @Override
    public String findOutMazeWay(MazeFileReader mazeFileReader) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }
}
