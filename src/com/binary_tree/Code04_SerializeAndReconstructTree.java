package com.binary_tree;

import com.sun.media.sound.SoftTuning;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

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


    }

}
