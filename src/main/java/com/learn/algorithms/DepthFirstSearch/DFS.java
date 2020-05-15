package com.learn.algorithms.DepthFirstSearch;

/* @author ravin @date 15-05-2020 @time 08:47 */

import com.learn.algorithms.commons.Node;
import com.learn.algorithms.utility.MazeFileReader;

import java.util.List;

public interface DFS<T> {

    String dfs(Node<T> root);

    String topologicalOrdering(List<Node<T>> nodes);

    String detectCycle(List<Node<T>> nodes);

    String findOutMazeWay(MazeFileReader mazeFileReader);

}
