package com.linklist;

import java.util.Stack;

/**
 * 链表是否为回文
 */
public class IsPalindromeList {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }



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


    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(2);

        System.out.println(" 是否为回文.." + isPalindromeList1(node));
    }
}
