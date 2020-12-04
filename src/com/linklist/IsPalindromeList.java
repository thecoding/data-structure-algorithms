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




    public static boolean linkedList(){
        return true;
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
            slow = head.next;
            fast = fast.next.next;
        }
        return slow;
    }




    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(2);

        System.out.println(" 是否为回文..栈实现..." + isPalindromeList1(node));
    }
}
