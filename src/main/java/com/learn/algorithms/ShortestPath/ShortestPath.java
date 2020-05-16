package com.learn.algorithms.ShortestPath;

/* @author ravin @date 16-05-2020 @time 12:17 */

import com.learn.algorithms.ShortestPath.common.Edge;
import com.learn.algorithms.ShortestPath.common.Node;

import java.util.List;

public interface ShortestPath {

    List<Node> computeShortestPath(Node source, Node target);

    List<Node> computeShortestPath(List<Node> nodes, List<Edge> edges, Node target);
}
