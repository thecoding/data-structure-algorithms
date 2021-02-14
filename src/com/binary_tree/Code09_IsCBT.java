package com.binary_tree;

import java.util.LinkedList;

/**
 * 完全二叉树（Complete Binary Tree）
 * 定义：
 *  完全二叉树从根结点到倒数第二层满足完美二叉树，最后一层可以不完全填充，其叶子结点都靠左对齐。
 *
 * 是否完全二叉树（按层遍历）
 * 1、没有左节点，只有右节点 return false
 *    --> l == null && r != null
 *
 * 2、当第一次遇到左右不双全的，剩下的节点必须是叶子节点
 *      --> leaf true表示为第二次为不双全  叶子节点--> l == null && r == null
 *      --> 取反： 剩下的不是叶子节点  l != null || r != null
 * Created by Mirko on 2021/2/14.
 */
public class Code09_IsCBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static boolean isCBT(Node node){
        if (node == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean leaf = false;
        //先按层遍历
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            Node l = curNode.left;
            Node r = curNode.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }


    /**
     * 完全二叉树四种可能
     * 1、左边是完全二叉树，右边是满二叉树，左边高度 = 右边高度+ 1
     * 2、左边是满二叉树，右边是满二叉树，左边高度 = 右边高度+ 1
     * 3、左边是满二叉树，右边是满二叉树，左边高度 = 右边高度
     * 4、左边是满二叉树，右边是完全二叉树，左边高度 = 右边高度
     * -->  isFull 是否为满二叉树
     * -->  height 高度
     * --> isCBT 是否为完全二叉树
     * @param head
     * @return
     */
    public static boolean isCBT2(Node head) {
        return process(head).isCBT;
    }

    public static Info process(Node head) {
        if (head == null) {
            return new Info(true, true, 0);
        }
        //TODO 构建info
        return new Info(false,false,0);
    }

    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
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
        System.out.println("isCBT : " + isCBT(head));
    }
}
