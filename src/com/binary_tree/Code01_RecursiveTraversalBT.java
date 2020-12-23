package com.binary_tree;

/**
 * 递归打印二叉树
 * @author Mirko
 * @Description
 * @createTime 2020年12月22日 00:33:00
 */
public class Code01_RecursiveTraversalBT {

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
        if (head == null) {
            return;
        }
        System.out.print(head.value);
        pre(head.left);
        pre(head.right);
    }

    //中序
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value);
        in(head.right);
    }

    //后序
    public static void after(Node head) {
        if (head == null) {
            return;
        }
        after(head.left);
        after(head.right);
        System.out.print(head.value);
    }


    /**
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

        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        after(head);
        System.out.println();
    }
}
