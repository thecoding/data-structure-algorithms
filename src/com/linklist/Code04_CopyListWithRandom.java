package com.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年12月21日 23:18:00
 */
public class Code04_CopyListWithRandom {


    /**
     * 当前节点有两个引用，一个指向下一个，一个指向一个随机节点
     */
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    //方法一：使用hashMap来进行复制，原理是 cur和new Node()新创建的节点一一对应
    //  new Node().next 就相当于  map.get(cur.next)  --> cur.next在map中一定会有引用，如果没有，就说明链表结束了
    public static Node copyListWithRand1(Node head) {
        Map<Node, Node> map = new HashMap<>();

        //循环链表，先进行节点复制
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }


    //方法二： 先一对一的复制每个节点，比如 node 复制出来为 node'
    //node next节点指向 node.next 那么 node' next节点指向就是 node'.next，
    // rand同样也是
    // 然后进行遍历拆分
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        // copy node'   并且将node'.next 指向 cur.next
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            Node copyNode = new Node(cur.value);
            cur.next = copyNode;
            copyNode.next = next;
            cur = next;
        }
        // copy rand 指向，cur.rand指向原rand节点，node'.rand指向的是cur.rand.next节点
        cur = head;
        Node copyNode = null;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            //可能会为空
            copyNode.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //拆分curNode和node'节点
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = copyNode.next;
            //可能会为空
            copyNode.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }





    /**
     * 题目要求： 给定随机的一个链表的头节点，进行复制
     * 解答方式一： 使用Map进行一一复制
     *
     * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
     * 给定一个由Node节点类型组成的无环单链表的头节点 head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
     * 【要求】
     * 时间复杂度O(N)，额外空间复杂度O(1)
     * @param args
     */
    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");
        res1 = copyListWithRand1(head);
        System.out.println("方法一的拷贝链表：");
        printRandLinkedList(res1);
        System.out.println("=========================");
        res2 = copyListWithRand2(head);
        System.out.println("方法二的拷贝链表：");
        printRandLinkedList(res2);
//        System.out.println("=========================");
//        System.out.println("经历方法二拷贝之后的原始链表：");
//        printRandLinkedList(head);
//        System.out.println("=========================");
    }


    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
