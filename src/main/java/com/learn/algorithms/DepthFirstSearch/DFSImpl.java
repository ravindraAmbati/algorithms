package com.learn.algorithms.DepthFirstSearch;

/* @author ravin @date 15-05-2020 @time 08:49 */

import com.learn.algorithms.common.Node;
import com.learn.algorithms.utility.MazeFileReader;

import java.util.List;
import java.util.Stack;

public class DFSImpl<T> implements DFS<T> {

    private static final String DELIMITER = " ";

    @Override
    public String dfs(Node<T> root) {

        StringBuilder result = new StringBuilder();
        Stack<Node<T>> stack = new Stack<>();

        stack.push(root);
        root.setVisited(true);
        result.append(root.getValue()).append(DELIMITER);

        while (!stack.isEmpty()) {

            Node<T> actual = stack.pop();
            List<Node<T>> children = actual.getChildren();

            for (Node<T> node : children) {
                if (!node.isVisited()) {
                    stack.push(node);
                    node.setVisited(true);
                    result.append(dfs(node));
                }
            }
        }

        return result.toString();
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
        throw new UnsupportedOperationException("This operation cannot be performed");
    }
}
