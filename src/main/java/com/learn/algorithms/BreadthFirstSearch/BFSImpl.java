package com.learn.algorithms.BreadthFirstSearch;

/* @author ravin @date 14-05-2020 @time 09:12 */

import com.learn.algorithms.commons.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSImpl<T> implements BFS<T> {

    @Override
    public String bfs(Node<T> root) {

        StringBuilder result = new StringBuilder();
        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);
        root.setVisited(true);

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
