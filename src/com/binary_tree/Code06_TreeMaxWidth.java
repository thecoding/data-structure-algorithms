package com.binary_tree;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 找出二叉树 最大宽度的层
 * @author Mirko
 * @Description
 * @createTime 2021年01月31日 23:57:00
 */
public class Code06_TreeMaxWidth {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用map和队列来计算最大的宽度
     *  过程：
     * @param head
     * @return
     */
    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> map = new HashMap<>();
        map.put(head, 1);//当前节点表示第几层
        int curLevel = 1; //表示层数
        int curLevelNode = 0;//层数的节点数
        int max = 0; //当前最大的宽度
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int currentLevel = map.get(curNode);
            if (curNode.left != null) {
                map.put(curNode.left, currentLevel + 1);
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                map.put(curNode.right, currentLevel + 1);
                queue.add(curNode.right);
            }
            if (currentLevel == curLevel) {
                curLevelNode++;
            }else{
                max = Math.max(max, curLevelNode);
                curLevel++;
                curLevelNode = 1;
            }
        }
        max = Math.max(max, curLevelNode);
        return max;
    }


    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head; //当前节点最后一个节点
        Node nextLevelNode = null; //下一层最后一个节点
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelNode = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelNode = cur.right;
            }
            curLevelNodes++;
            if (curEnd == cur) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextLevelNode;
            }
        }
        return max;
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
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWidthNoMap(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

//        Node head = new Node(1);
//        head.left = new Node(2);
//        head.right = new Node(3);
//        head.left.left = new Node(4);
//        head.left.right = new Node(5);
//        head.right.left = new Node(6);
//        head.right.right = new Node(7);
////        System.out.println("head 最大的宽度是：" + maxWidthUseMap(head));
//
//        System.out.println("head 最大的宽度是：" + maxWidthNoMap(head));
    }
}
