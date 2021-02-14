package com.binary_tree;

/**
 * 给你二叉树中的某个节点，返回该节点的后继节点
 * 说明：后继节点是二叉树中序排列该节点的下一个节点
 * 结构上的特点： 当前节点的如果存在右节点，那他的后继节点就应该是右树的最左节点
 *              如果没有右节点，就往上找
 * 所以就两种可能： 1、有右节点就是右节点的最左节点
 *                2、没有右节点就是当前节点的父节点
 * @author Mirko
 * @Description
 * @createTime 2021年02月02日 01:15:00
 */
public class Code07_SuccessorNode {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node){
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            //如果存在右边节点，就取右边节点的最左节点
            return getLeftNode(node.right);
        }else{
            Node parent = node.parent;
            //这是个关键点：1、父节点是空，说明说明是一直往上找，没找到父节点，表示没有后继节点
            // 2、当前节点为父节点的左节点，表示是后继节点
            while (parent != null && parent.right == node) {
                node = node.parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getLeftNode(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }
}
