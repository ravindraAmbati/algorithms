package com.learn.algorithms.ShortestPath.common;

/* @author ravin @date 16-05-2020 @time 10:44 */

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    private String name;
    private List<Edge> neighbours = new ArrayList<>();
    private boolean visited;
    private Node predecessor;
    private Double distance = Double.MAX_VALUE;

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbours(Edge edge) {
        this.neighbours.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Edge> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Node node) {
        return Double.compare(this.distance, node.distance);
    }
}
