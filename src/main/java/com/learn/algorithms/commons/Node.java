package com.learn.algorithms.commons;

/* @author ravin @date 14-05-2020 @time 09:07 */

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T value;
    private boolean isVisited;
    private boolean isBeingVisited;
    private List<Node<T>> children;

    public Node(T value) {
        this.value = value;
        this.children = new ArrayList<Node<T>>();
    }

    public void addChild(Node<T> node) {
        this.children.add(node);
    }

    public void addChildren(List<Node<T>> nodes) {
        this.children.addAll(nodes);
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

    public boolean isBeingVisited() {
        return isBeingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        isBeingVisited = beingVisited;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", isVisited=" + isVisited +
                ", neighbours=" + children +
                '}';
    }

}
