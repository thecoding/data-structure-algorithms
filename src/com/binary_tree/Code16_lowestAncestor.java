package com.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一棵二叉树的头节点head，和另外两个节点a和b。
 * 返回a和b的最低公共祖先
 */
public class Code16_lowestAncestor {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // 从结果出发分析
    // 跟head有关： 1、左边发现a，右边发现b  2、左边发现b，右边发现a  --> 头节点就是head
    // 跟head无关： 3、都在左边（找到head）  4、都在右边（找到head）  -->
    // 总结元素：发现a  发现b  head

    public static class Info{
        public Node ans;
        public boolean findA;
        public boolean findB;

        public Info(Node ans, boolean findA, boolean findB) {
            this.ans = ans;
            this.findA = findA;
            this.findB = findB;
        }
    }

    public static Node findHead(Node head, Node a, Node b) {
        if (head == null) {
            return null;
        }
        return process(head, a, b).ans;
    }

    public static Info process(Node head, Node a, Node b) {
        if (head == null) {
            return new Info(null,false,false);
        }
        Info leftInfo = process(head.left, a, b);
        Info rightInfo = process(head.right,a,b);

        Node ans = null;
        boolean findA = (head == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (head == b) || leftInfo.findB || rightInfo.findB;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (findA && findB) {
                ans = head;
            }
        }
        return new Info(ans, findA, findB);
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

    // for test
    public static Node pickRandomOne(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> arr = new ArrayList<>();
        fillPrelist(head, arr);
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    // for test
    public static void fillPrelist(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            Node o1 = pickRandomOne(head);
            Node o2 = pickRandomOne(head);
            if (findHead(head, o1, o2) != lowestAncestor2(head, o1, o2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }


    public static Node lowestAncestor2(Node head, Node o1, Node o2) {
        if (head == null) {
            return null;
        }
        // key的父节点是value
        HashMap<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);
        HashSet<Node> o1Set = new HashSet<>();
        Node cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    public static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }
}
