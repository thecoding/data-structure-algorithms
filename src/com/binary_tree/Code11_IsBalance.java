package com.binary_tree;

/**
 * 平衡二叉树
 * 定义：
 * 1、可以是空树。
 * 2、假如不是空树，任何一个结点的左子树与右子树都是平衡二叉树，并且高度之差的绝对值不超过 1。
 * Created by Mirko on 2021/2/14.
 */
public class Code11_IsBalance {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * 是否是平衡二叉树：
     * 1、左边是否是平衡二叉树
     * 2、右边是否是平衡二叉树
     * 3、两边的树的高度是否相差大于1
     * @param head
     * @return
     */
    public static boolean isBalance(Node head) {
        return process(head).isBalance;
    }

    public static Info process(Node head){
        if (head == null) {
            return new Info(true, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);

        boolean isBalance = true;
        int height = Math.max(left.height, right.height) + 1;
        if (!left.isBalance || !right.isBalance) {
            isBalance = false;
        }
        if (Math.abs(left.height - right.height) > 1) {
            isBalance = false;
        }
        return new Info(isBalance,height);
    }

    public static class Info{
        public boolean isBalance;
        public int height;

        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
//        head.right.left = new Node(6);
//        head.right.right = new Node(7);
        System.out.println("isBalance : " + isBalance(head));
    }
}
