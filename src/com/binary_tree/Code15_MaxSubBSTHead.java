package com.binary_tree;

import java.util.ArrayList;

/**
 *
 * 给定一棵二叉树的头节点head，
 * 返回这颗二叉树中最大的二叉搜索子树的头节点
 */
public class Code15_MaxSubBSTHead {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    // 和head无关： 左边搜索二叉树的头节点   右边搜索二叉树的头节点
    // 和head有关： 左边是搜索二叉树，右边是搜索二叉树，并且左边最大value < 当前节点value  < 右边最大value
    // 总结需要的元素： 是否是搜索二叉树，maxValue，minValue，head
    // 左右两边是否是搜索二叉树： 左边搜索二叉树的头节点 == 当前节点的left (左边是否是搜索二叉树)
    // 右边搜索二叉树头节点 == 当前节点的right


    // 向左-向右 需要什么信息
    public static class Info{
        //两边头节点
        public Node maxSubBSTHead;
        //搜索二叉树的大小
        public int maxSubBSTSize;
        //value最大值
        public int max;
        //value最小值
        public int min;

        public Info(Node maxSubBSTHead, int maxSubBSTSize, int max, int min) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.maxSubBSTSize = maxSubBSTSize;
            this.max = max;
            this.min = min;
        }
    }


    public static Node maxSubBSTHead2(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).maxSubBSTHead;
    }

    public static Info process(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        Node maxSubBSTHead = null;
        int maxSubBSTSize = 0;
        int max = x.value;
        int min = x.value;

        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            maxSubBSTHead = leftInfo.maxSubBSTHead;
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            //右边的搜索二叉树比当前的的最大搜索二叉树大，就取右边的信息
            if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
                maxSubBSTHead = rightInfo.maxSubBSTHead;
                maxSubBSTSize = rightInfo.maxSubBSTSize;
            }
        }

        //两边都有的情况，并且组合起来就是最大的搜索二叉树，关键点-->  x.left == leftInfo.maxSubBSTHead   x.right == rightInfo.maxSubBSTHead
        if((leftInfo == null || (leftInfo.max < x.value && x.left == leftInfo.maxSubBSTHead)) &&
                (rightInfo == null || (x.value < rightInfo.min && x.right == rightInfo.maxSubBSTHead))){
            maxSubBSTHead = x;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }
        return new Info(maxSubBSTHead,maxSubBSTSize,max,min);
    }


    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != maxSubBSTHead2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }


    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static Node maxSubBSTHead1(Node head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        Node leftAns = maxSubBSTHead1(head.left);
        Node rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }
}
