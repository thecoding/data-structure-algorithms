package com.linklist;

import java.util.ArrayList;

public class LinkListMid {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //传入头结点 --> 返回中点(上中点)
    public static Node midOrUpMidNode(Node head){
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

    // 返回的是下中点
    public static Node midOrDownMidNode(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 返回上中点的上一个节点
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 返回下中点的上一个节点
    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 1) / 2);
    }

    public static Node right2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get(arr.size() / 2);
    }

    public static Node right3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 3) / 2);
    }

    public static Node right4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 2) / 2);
    }

    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
//        node.next.next.next.next.next.next = new Node(7);
//        node.next.next.next.next.next.next.next = new Node(8);
//        node.next.next.next.next.next.next.next.next = new Node(9);


        Node ans1 = null;
        Node ans2 = null;

        //当node为单数的时候，返回的是中间结点，当node为偶数的时候，一个返回的是上中点，一个返回的下中点
        Node midUpMid = midOrUpMidNode(node);
        System.out.println("midUpMid --> "+midUpMid.value);
        Node node3 = right1(node);
        System.out.println("right1 --> " + node3.value);

        Node midDownMid = midOrDownMidNode(node);
        System.out.println("midDownMid --> "+midDownMid.value);
        Node node2 = right2(node);
        System.out.println("right2 --> " + node2.value);



        //返回上中点的上一个节点
        Node midOrUpMidPreNode = midOrUpMidPreNode(node);
        System.out.println("midOrUpMidPreNode --> "+midOrUpMidPreNode.value);

        Node node1 = midOrDownMidPreNode(node);
        System.out.println("midOrDownMidPreNode --> "+node1.value);

        Node node4 = right4(node);
        System.out.println("node4 --> " + node4.value);

        System.out.println(" ----------------------  ");

        ans1 = midOrUpMidPreNode(node);
        ans2 = right3(node);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrDownMidPreNode(node);
        System.out.println(ans1 != null ? ans1.value : "无");



    }
}
