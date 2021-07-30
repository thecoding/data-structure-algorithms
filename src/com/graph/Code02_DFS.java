package com.graph;



import java.util.*;

/**
 * 图的宽度遍历
 * 采用队列，先进先出。
 */
public class Code02_DFS {

    public static void printByDFS(Node node){
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.getNexts()) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }
    }

}
