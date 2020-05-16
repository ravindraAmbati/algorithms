package com.learn.algorithms.ShortestPath;

/* @author ravin @date 16-05-2020 @time 11:27 */

import com.learn.algorithms.ShortestPath.common.Edge;
import com.learn.algorithms.ShortestPath.common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra implements ShortestPath {

    public List<Node> computeShortestPath(Node source, Node target) {
        computeShortestPath(source);
        return getShortestPathTo(target);
    }

    @Override
    public List<Node> computeShortestPath(List<Node> nodes, List<Edge> edges, Node target) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    private void computeShortestPath(Node root) {

        root.setDistance(0d);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(root);

        while (!priorityQueue.isEmpty()) {
            Node actual = priorityQueue.poll();

            for (Edge edge : actual.getNeighbours()) {

                Node targetNode = edge.getTarget();

                double newDistance = actual.getDistance() + edge.getWeight();

                if (newDistance < targetNode.getDistance()) {

                    priorityQueue.remove(targetNode);
                    targetNode.setDistance(newDistance);
                    targetNode.setPredecessor(actual);
                    priorityQueue.add(targetNode);
                }
            }
        }
    }

    private List<Node> getShortestPathTo(Node target) {

        List<Node> shortestPathTo = new ArrayList<>();

        for (Node node = target; null != node; node = node.getPredecessor()) {
            shortestPathTo.add(node);
        }

        Collections.reverse(shortestPathTo);
        return shortestPathTo;
    }
}
