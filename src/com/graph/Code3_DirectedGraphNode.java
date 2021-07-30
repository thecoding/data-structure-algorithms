package com.graph;

import java.util.ArrayList;
import java.util.List;


/**
 *  OJ链接：https://www.lintcode.com/problem/topological-sorting
 * @author Mirko
 * @date
 * @description 给定一个有向图，图节点的拓扑排序定义如下:
 * 对于图中的每一条有向边 A -> B , 在拓扑排序中A一定在B之前.
 * 拓扑排序中的第一个节点可以是图中的任何一个没有其他节点指向它的节点.
 * 针对给定的有向图找到任意一种拓扑排序的顺序.
 */
public class Code3_DirectedGraphNode {

    // Definition forDirected graph.

    class DirectedGraphNode {
        int label;
        List<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    public class Solution {
        /**
         * @param graph: A list of Directed graph node
         * @return: Any topological order for the given graph.
         */
        public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
            // write your code here

            return null;
        }
    }
}
