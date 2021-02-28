package com.binary_tree;

import java.util.ArrayList;

/**
 * 给定一棵二叉树的头节点head，
 * 返回这颗二叉树中最大的二叉搜索子树的大小
 *
 * 搜索二叉树： 当前节点比左边节点大，比右边节点小
 *
 * Created by Mirko on 2021/2/14.
 */
public class Code14_MaxSubBSTSize {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //1、最大搜索二叉树跟头节点无关： 左边最大搜索二叉树，右边最大搜索二叉树，比较最大节点的数
    //2、跟头节点有关，说明整棵树是搜索二叉树，左边是搜索二叉树，右边是搜索二叉树，并且左边的最大节点小于当前节点，当前节点小于右边最小节点
    //汇总元素：是否是二叉树，最小值，最大值，最大搜索二叉树大小，左边size，右边size
    // 是否是搜索二叉树 --> 树的大小allSize == 最大搜索二叉树大小maxBSTSubSize

    public static class Info{
        public int maxBSTSubSize;
        public int max;
        public int min;
        public int allSize;

        public Info(int maxBSTSubSize, int max, int min, int allSize) {
            this.maxBSTSubSize = maxBSTSubSize;
            this.max = max;
            this.min = min;
            this.allSize = allSize;
        }
    }

    public static int process(Node head){
        if (head == null) {
            return 0;
        }
        return processDetail(head).maxBSTSubSize;
    }

    public static Info processDetail(Node head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = processDetail(head.left);
        Info rightInfo = processDetail(head.right);

        int allSize = 1;
        int max = head.value;
        int min = head.value;

        int p1 = -1;
        int p2 = -1;
        if (leftInfo != null) {
            allSize += leftInfo.allSize;
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            p1 = leftInfo.maxBSTSubSize;
        }

        if (rightInfo != null) {
            allSize += rightInfo.allSize;
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            p2 = rightInfo.maxBSTSubSize;
        }

        int p3 = -1;
        boolean leftBST = leftInfo == null || leftInfo.allSize == leftInfo.maxBSTSubSize;
        boolean rightBST = rightInfo == null || rightInfo.allSize == rightInfo.maxBSTSubSize;
        if (leftBST && rightBST) {
            boolean left = leftInfo == null || leftInfo.max < head.value;
            boolean right = rightInfo == null || head.value < rightInfo.min;
            if (left && right) {
                int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }
        int maxBSTSubSize = Math.max(p3, Math.max(p1, p2));
        return new Info(maxBSTSubSize,max,min,allSize);
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
            if (maxSubBSTSize1(head) != process(head)) {
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

    public static int maxSubBSTSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

}
