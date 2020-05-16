package com.learn.algorithms.ShortestPath;

/* @author ravin @date 16-05-2020 @time 13:01 */

import com.learn.algorithms.ShortestPath.common.Edge;
import com.learn.algorithms.ShortestPath.common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFord implements ShortestPath {

    @Override
    public List<Node> computeShortestPath(Node source, Node target) {
        throw new UnsupportedOperationException("This operation cannot be performed");
    }

    @Override
    public List<Node> computeShortestPath(List<Node> nodes, List<Edge> edges, Node target) {
        Node root = nodes.get(0);
        root.setDistance(0d);
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (Edge edge : edges) {
                Node s = edge.getSource();
                Node t = edge.getTarget();
                if (Double.MAX_VALUE == s.getDistance()) continue;
                double newDistance = s.getDistance() + edge.getWeight();
                if (newDistance < t.getDistance()) {
                    t.setDistance(newDistance);
                    t.setPredecessor(s);
                }
            }
        }
        for (Edge edge : edges) {
            if (Double.MAX_VALUE != edge.getSource().getDistance()) {
                if (isCycle(edge)) {
                    System.out.println("Cycle has been detected");
                    break;
                }
            }
        }
        return getShortestPathTo(root, target);
    }

    private boolean isCycle(Edge edge) {
        return edge.getSource().getDistance() + edge.getWeight() < edge.getTarget().getDistance();
    }

    private List<Node> getShortestPathTo(Node source, Node target) {

        if (Double.MAX_VALUE == target.getDistance()) System.out.println("No Path");
        List<Node> shortestPathTo = new ArrayList<>();

        while (null != target.getPredecessor()) {
            shortestPathTo.add(target);
            target = target.getPredecessor();
        }
        shortestPathTo.add(source);
        Collections.reverse(shortestPathTo);
        return shortestPathTo;
    }
}
