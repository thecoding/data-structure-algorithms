package com.binary_tree;

/**
 * 完美二叉树(Perfect Binary Tree) 又名：满二叉树
 * 定义：
 *  一个深度为k(>=-1)且有2^(k+1) - 1个结点的二叉树称为完美二叉树。 (注： 国内的数据结构教材大多翻译为"满二叉树")
 *  A Perfect Binary Tree(PBT) is a tree with all leaf nodes at the same depth.
 * All internal nodes have degree 2.
 *
 * 是否是完美二叉树：
 *
 * Created by Mirko on 2021/2/14.
 */
public class Code12_IsPBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static boolean isPBT(Node head) {
        if (head == null) {
            return true;
        }
        int h = h(head);
        int n = n(head);
        return (1 << h) -1 == n;
    }

    private static int n(Node head) {
        if (head == null) {
            return 0;
        }
        return n(head.left) + n(head.right) + 1;
    }

    private static int h(Node head) {
        if (head == null) {
            return 0;
        }
        return Math.max(h(head.left),h(head.right)) + 1;
    }


    public static boolean isPBT2(Node head) {
        if (head == null) {
            return true;
        }
        Info info = process(head);
        return (1 << info.height) - 1 == info.nodes;
    }

    private static Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);
        return new Info(Math.max(left.height,right.height) + 1, left.nodes + right.nodes + 1);
    }


    public static class Info{
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        System.out.println("isPBT : " + isPBT2(head));
    }
}
