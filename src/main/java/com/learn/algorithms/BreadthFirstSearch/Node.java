package com.learn.algorithms.BreadthFirstSearch;

/* @author ravin @date 14-05-2020 @time 09:07 */

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T value;
    private boolean isVisited;
    private List<Node<T>> neighbours;

    public Node(T value) {
        this.value = value;
        this.neighbours = new ArrayList<Node<T>>();
    }

    public void addNeighbours(Node<T> node){
        this.neighbours.add(node);
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Node<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node<T>> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", isVisited=" + isVisited +
                ", neighbours=" + neighbours +
                '}';
    }
}
