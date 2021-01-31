package com.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的相交节点
 * @author Mirko
 * @Description
 * @createTime 2020年12月22日 00:06:00
 */
public class Code05_FindFirstIntersectNode {


    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 两个链表是否右相交节点 (不能处理链表是有环链表的情况，所有有缺陷)
     * @param head1
     * @param head2
     * @return null or node(相交第一个节点)
     */
    public static Node hasContainNode(Node head1, Node head2) {
        Set<Node> setNode = new HashSet<>();
        while (head1 != null) {
            setNode.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if(setNode.contains(head2)){
               return head2;
            }
            head2 = head2.next;
        }
        return null;
    }


    public static Node getFirstNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoopNode(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return loopNode(head1, head2,loop1,loop2);
        }
        return null;
    }

    //获取无环链表的第一个相交节点
    private static Node noLoopNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node node1 = head1;
        Node node2 = head2;
        int n = 0;
        while (node1 != null) {
            n++;
            node1 = node1.next;
        }
        while (node2 != null) {
            n--;
            node2 = node2.next;
        }
        node1 = n > 0 ? head1 : head2;
        node2 = n > 0 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            node1 = node1.next;
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }


    //获取有环的链表的第一个相交节点
    private static Node loopNode(Node head1, Node head2, Node loopNode1, Node loopNode2) {
        if (loopNode1 == loopNode2) {
            Node node1 = head1;
            Node node2 = head2;
            int n = 0;
            while (node1 != null) {
                n++;
                node1 = node1.next;
            }
            while (node2 != null) {
                n--;
                node2 = node2.next;
            }
            node1 = n > 0 ? head1 : head2;
            node2 = n > 0 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                node1 = node1.next;
            }
            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }else{
            Node cur = loopNode1.next;
            while (cur != loopNode1) {
                if (cur == loopNode2) {
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }
    }


    //获取第一个相交节点，有则返回第一个相交节点，没有则返回null
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast;
    }


    /**
     * 题目：给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
     * 【要求】
     * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)。
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node head2 = new Node(7);
        head2.next = new Node(8);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(10);
        head2.next.next.next.next = head.next.next.next;


        //如果其中一个是有环结构，那set就会无线循环。。。。比如下面的
//         head.next.next.next.next.next.next = head.next.next.next;

        //Test1 hasContainNode
//        Node node = hasContainNode(head, head2);
//        System.out.println(node == null ? "null" : node.value);

        // getLoopNodeTest
//        // head.next.next.next.next.next.next = head.next.next.next;
//        Node loopNode = getLoopNode(head);
//        System.out.println(loopNode == null ? "null" : loopNode.value);

        //noLoopNode 两个无环链表测试
        Node firstNode = getFirstNode(head, head2);
        System.out.println(firstNode == null ? "null" : firstNode.value);

    }
}
