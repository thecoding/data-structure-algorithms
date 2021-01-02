package com.binary_tree;

import java.util.Stack;

/**
 * 非递归打印二叉树(借助stack)
 * @author Mirko
 * @Description
 * @createTime 2020年12月22日 00:33:00
 */
public class Code02_UnRecursiveTraversalBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //先序
    public static void pre(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node h = stack.pop();
                System.out.print(h.value + " ");
                if (h.right != null) {
                    stack.push(h.right);
                }
                if (h.left != null) {
                    stack.push(h.left);
                }
            }
        }
    }

    //中序--> 打印： 左  头  右
    public static void in(Node cur) {
        if (cur != null) {
            Stack<Node> stack = new Stack();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }else{
                    cur = stack.pop();
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
    }

    //后序 -> 左  右  头
    public static void after(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        //头左右-> 头右左
        while (!s1.isEmpty()) {
            Node h = s1.pop();
            s2.push(h);
            if (h.left != null) {
                s1.push(h.left);
            }
            if (h.right != null) {
                s1.push(h.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }
    }


    /**
     * 非递归实现
     * 题目：实现先序、中序、后序打印该二叉树
     * 先序：任何子树的处理顺序都是，先头节点、再左子树、然后右子树
     * 中序：任何子树的处理顺序都是，先左子树、再头节点、然后右子树
     * 后序：任何子树的处理顺序都是，先左子树、再右子树、然后头节点
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        // 1-2-4-5-3-6-7
        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        after(head);
        System.out.println();
    }
}
