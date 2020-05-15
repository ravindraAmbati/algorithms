package com.learn.algorithms.BreadthFirstSearch;

/* @author ravin @date 14-05-2020 @time 09:12 */

import com.learn.algorithms.commons.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSImpl<T> implements BFS<T> {

    @Override
    public void bfs(Node<T> root){

        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);
        root.setVisited(true);

        while (!queue.isEmpty()){

            Node<T> actual = queue.remove();
            List<Node<T>> neighbours = actual.getChildren();

            for(Node<T> node: neighbours){
                if(!node.isVisited()){
                    queue.add(node);
                    node.setVisited(true);
                    System.out.println(node.getValue());
                }
            }
        }
    }
}
