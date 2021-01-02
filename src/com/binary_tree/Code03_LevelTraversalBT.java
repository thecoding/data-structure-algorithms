package com.binary_tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mirko
 * @Description 按层打印二叉树
 * @createTime 2020年12月30日 23:02:00
 */
public class Code03_LevelTraversalBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void level(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (queue.size() > 0) {
            Node curNode = queue.poll();
            System.out.print(curNode.value + " ");
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        level(head);
    }
}

