package com.binary_tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化
 * @author Mirko
 * @Description
 * @createTime 2021年01月02日 00:34:00
 */
public class Code04_SerializeAndReconstructTree {

    public static class Node{
        public int value;
        public Node right;
        public Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 先序序列化 先头-左-右
     * @param head
     * @return
     */
    public static Queue<Integer> preSer(Node head) {
        Queue<Integer> queue = new LinkedList<>();
        pre(head, queue);
        return queue;
    }

    private static void pre(Node head,Queue<Integer> queue) {
        if (head == null) {
            queue.add(null);
        }else{
            queue.add(head.value);
            pre(head.left, queue);
            pre(head.right, queue);
        }
    }


    /**
     * 中序序列化 左 - 头 - 右
     * @param head
     * @return
     */
    public static Queue<Integer> inSer(Node head) {
        Queue<Integer> queue = new LinkedList<>();
        in(head, queue);
        return queue;
    }

    private static void in(Node head,Queue<Integer> queue) {
        if (head == null) {
            queue.add(null);
        }else{
            in(head.left, queue);
            queue.add(head.value);
            in(head.right, queue);
        }
    }


    public static Queue<Integer> aftSer(Node head) {
        Queue<Integer> queue = new LinkedList<>();
        aft(head, queue);
        return queue;
    }

    private static void aft(Node head,Queue<Integer> queue) {
        if (head == null) {
            queue.add(null);
        }else{
            aft(head.left, queue);
            aft(head.right, queue);
            queue.add(head.value);
        }
    }

    /*******************以上是序列化***********************/


    /*******************以下是反序列化***********************/


    /**
     * 先序反序列化
     * @param pre
     * @return
     */
    public static Node buildPreSer(Queue<Integer> pre) {
        if (pre == null || pre.size() == 0) {
            return null;
        }
        return bPre(pre);
    }

    private static Node bPre(Queue<Integer> pre) {
        Integer poll = pre.poll();
        if (poll == null) {
            return null;
        }
        Node head = new Node(poll.intValue());
        head.left = bPre(pre);
        head.right = bPre(pre);
        return head;
    }


    /**
     * 后序-反序列化
     * @param aft
     * @return
     */
    public static Node buildAftPre(Queue<Integer> aft) {
        if (aft == null || aft.size() == 0) {
            return null;
        }
        //左右中 --> stack 中右左
        Stack<Integer> integers = new Stack<>();
        while (aft.size() > 0) {
            integers.add(aft.poll());
        }
        return bAft(integers);
    }

    private static Node bAft(Stack<Integer> aft) {
        Integer value = aft.pop();
        if (value == null) {
            return null;
        }
        Node head = new Node(value.intValue());
        head.right = bAft(aft);
        head.left = bAft(aft);
        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        Queue<Integer> pre = preSer(head);
        System.out.println(" 先序: "+ pre.toString());

        Queue<Integer> in = inSer(head);
        System.out.println(" 中序: "+ in.toString());

        Queue<Integer> aft = aftSer(head);
        System.out.println(" 后序: "+ aft.toString());

        Node buildPreSer = buildPreSer(pre);
        System.out.println(" 先序反序列化 " + buildPreSer.toString());

        Node buildAftPre = buildAftPre(aft);
        System.out.println(" 后序反序列化.. " + buildAftPre.toString());
    }

}
