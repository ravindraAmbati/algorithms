package com.learn.algorithms.DepthFirstSearch;

/* @author ravin @date 15-05-2020 @time 17:23 */

import com.learn.algorithms.common.Node;
import com.learn.algorithms.utility.MazeFileReader;

import java.util.List;
import java.util.Stack;

public class CycleDetection<T> implements DFS<T> {

    private static final String DELIMITER = " | ";
    private Stack<Node<T>> stack = null;

    @Override
    public String dfs(Node<T> root) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    @Override
    public String topologicalOrdering(List<Node<T>> nodes) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    private void detectCycle(Node<T> root) {

        root.setBeingVisited(true);
        List<Node<T>> children = root.getChildren();
        for (Node<T> node : children) {
            if (node.isBeingVisited()) {
                stack.push(node);
                System.out.println("Cycle Detect at position: " + root.getValue() + "<->" + node.getValue());
                return;
            }
            if (!node.isVisited()) {
                node.setVisited(true);
                detectCycle(node);
            }
        }
        stack.push(root);
    }

    @Override
    public String detectCycle(List<Node<T>> nodes) {

        stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (Node<T> node : nodes) {
            if (!node.isVisited()) {
                detectCycle(node);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop().getValue()).append(DELIMITER);
        }
        return result.toString();
    }

    @Override
    public String findOutMazeWay(MazeFileReader mazeFileReader) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }
}
