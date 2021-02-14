package com.binary_tree;

/**
 * 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，
 * 返回整棵二叉树的最大距离
 * Created by Mirko on 2021/2/14.
 */
public class Code13_MaxDistance {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static int max(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).max;
    }

    private static Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int height = Math.max(left.height, right.height) + 1;
        int p1 = left.max;
        int p2 = right.max;
        int p3 = left.height + right.height + 1;
        int max = Math.max(Math.max(p1, p2), p3);
        return new Info(height, max);
    }

    public static class Info{
        public int height;
        public int max;

        public Info(int height, int max) {
            this.height = height;
            this.max = max;
        }
    }
}
