package com.learn.algorithms.BreadthFirstSearch;

/* @author ravin @date 14-05-2020 @time 09:12 */

import com.learn.algorithms.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSImpl<T> implements BFS<T> {

    private static final String DELIMITER = " ";

    @Override
    public String bfs(Node<T> root) {

        StringBuilder result = new StringBuilder();
        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);
        root.setVisited(true);
        result.append(root.getValue()).append(DELIMITER);

        while (!queue.isEmpty()) {

            Node<T> actual = queue.remove();
            List<Node<T>> children = actual.getChildren();

            for (Node<T> node : children) {
                if (!node.isVisited()) {
                    queue.add(node);
                    node.setVisited(true);
                    result.append(node.getValue()).append(" ");
                }
            }
        }
        return result.toString();
    }
}
