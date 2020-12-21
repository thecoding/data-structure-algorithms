package com.linklist;

import java.util.Stack;

/**
 * 链表是否为回文
 */
public class Code02_IsPalindromeList {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * 栈实现
     * @param head 链表的头节点
     * @return
     */
    public static boolean isPalindromeList1(Node head){
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (head != null) {
            //只要一个值不相等就不是回文了
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //如果是二分之一的空间，就使用栈的一半就行




    public static boolean linkedList(Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next; // --> mid
            n2 = n2.next.next; // -->
        }

        //begin mid recover
        n2 = n1.next; //下一个节点
        n1.next = null; //中点
        Node n3 = null; // n2的下一个节点
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        //n1 是最右边的节点，n2为null

        n3 = n1;  //右边最开始的节点，保存临时节点，因为要移动
        n2 = head; //左边最开始的节点
        boolean isPalindrome = true;
        while (n1 != null) {
            if (n1.value != n2.value) {
                isPalindrome =  false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //还原链表
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return isPalindrome;
    }


    /**
     * 返回中点（上中点）
     * @param head
     * @return
     */
    public Node midOrUpMidNode(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 给定一个单链表的头节点head，请判断该链表是否为回文结构。
     * 1）哈希表方法特别简单（笔试用）
     * 2）改原链表的方法就需要注意边界了（面试用）
     * @param args
     */
    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);

        System.out.println(" 是否为回文..栈实现..." + isPalindromeList1(node));
        System.out.println("--------------");
        boolean b = linkedList(node);
        System.out.println("linkeds是否为回文。。" + b);
        print(node);

    }


    public static void print(Node node){
        while(node != null){
            System.out.print(String.format("%s ",node.value));
            node = node.next;
        }
        System.out.println();
    }
}
