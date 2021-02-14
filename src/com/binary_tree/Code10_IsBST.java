package com.binary_tree;

/**
 * 搜索二叉树
 * 定义：
 * 1、左边的节点的所有值都小于当前节点的值 --> left.max <= head.value
 * 2、右边的节点所有值都大于当前节点的值  --> right.min >= head.value
 * Created by Mirko on 2021/2/14.
 */
public class Code10_IsBST {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST(Node head){
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    private static Info process(Node head) {
        if (head == null) {
            return null;
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int max = head.value;
        if (left != null) {
            max = Math.max(max, left.max);
        }
        if (right != null) {
            max = Math.max(max, right.max);
        }
        int min = head.value;
        if (left != null) {
            min = Math.min(min, left.min);
        }
        if (right != null) {
            min = Math.min(min, right.min);
        }
        boolean isBST = true;
        if (left != null && !left.isBST) {
            isBST = false;
        }
        if (right != null && !right.isBST) {
            isBST = false;
        }
        //左边最大的大于当前节点为false
        if (left != null && left.max >= head.value) {
            isBST = false;
        }
        //右边最小的小于当前节点为false
        if (right != null && right.min <= head.value) {
            isBST = false;
        }
        return new Info(isBST,max,min);
    }


    public static class Info{
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(7);
        head.left.left = new Node(1);
        head.left.right = new Node(4);
        head.left.left.right = new Node(2);
        head.right.left = new Node(6);
        head.right.right = new Node(8);
        System.out.println("isBST : " + isBST(head));
    }
}
