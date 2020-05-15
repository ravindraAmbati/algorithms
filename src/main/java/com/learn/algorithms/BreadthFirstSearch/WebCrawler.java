package com.learn.algorithms.BreadthFirstSearch;

/* @author ravin @date 15-05-2020 @time 10:43 */

import com.learn.algorithms.commons.Node;
import com.learn.algorithms.utility.ExtractURLs;
import com.learn.algorithms.utility.ReadHTML;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WebCrawler<T> implements BFS<T> {

    private static final String DELIMITER = " || ";

    @Override
    public String bfs(Node<T> root) {
        if (!(root.getValue() instanceof URL)) {
            throw new UnsupportedOperationException("this operation cannot be performed");
        }
        StringBuilder result = new StringBuilder();
        Queue<Node<URL>> queue = new LinkedList<>();

        queue.add((Node<URL>) root);
        root.setVisited(true);
        System.out.print(root.getValue() + DELIMITER);
        result.append(root.getValue()).append(DELIMITER);

        while (!queue.isEmpty()) {

            Node<URL> actual = queue.remove();
            try {
                ExtractURLs.extractHTTPURLs(ReadHTML.readHTML(actual.getValue())).forEach(
                        url -> actual.addChild(new Node<>(url))
                );
            } catch (IOException e) {
                System.out.println("Unreachable " + actual.getValue());
            }
            List<Node<URL>> children = actual.getChildren();

            for (Node<URL> node : children) {
                if (!node.isVisited()) {
                    queue.add(node);
                    node.setVisited(true);
                    System.out.print(node.getValue() + DELIMITER);
                    result.append(root.getValue()).append(DELIMITER);
                }
            }
        }
        return result.toString();
    }
}
