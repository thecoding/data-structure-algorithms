package com.graph;



import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 图的宽度遍历
 * 采用队列，先进先出。
 */
public class Code01_BFS {

    public static void printByBFS(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : cur.getNexts()) {
                if (!set.contains(cur)) {
                    queue.add(next);
                    set.add(cur);
                }
            }
        }
    }

}
