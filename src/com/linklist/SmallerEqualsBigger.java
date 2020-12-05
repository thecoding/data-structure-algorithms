package com.linklist;

/**
 * @author Mirko
 * @Description 将链表中的数据分成 左边小  中间相等，右边大
 * @createTime 2020年12月05日 14:45:00
 */
public class SmallerEqualsBigger {
    
    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }


    public static Node arrayTest(Node head, int num){
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] arr = new Node[i];

        i = 0;
        cur = head;
        while (cur != null) {
            arr[i] = cur;
            i++;
            cur = cur.next;
        }

        //再把arr进行分组
        change(arr, num);
        printArr(arr);
        for (int j = 1; j < arr.length; j++) {
            arr[j - 1].next = arr[j];
        }
        arr[arr.length - 1].next = null;
        return arr[0];
    }

    public static void printArr(Node[] arr) {
        System.out.println("打印 array ");
        for (Node node : arr) {
            System.out.print(node.value + " ");
        }
        System.out.println("");
    }


    public static Node[] change(Node[] arr, int num) {
        int small = -1;
        int big = arr.length;
        int index = 0;
        while (index != big) {
            if (arr[index].value < num) {
                small++;
                Node tmp = arr[small];
                arr[small] = arr[index];
                arr[index] = tmp;
                index++;
            } else if (arr[index].value == num) {
                index++ ;
            }else{
                big--;
                Node tmp = arr[big];
                arr[big] = arr[index];
                arr[index] = tmp;
            }
        }
        return arr;
    }




    public static void main(String[] args) {
        Node node = null;
        node = new Node(19);
        node.next = new Node(12);
        node.next.next = new Node(13);
        node.next.next.next = new Node(34);
        node.next.next.next.next = new Node(25);
        node.next.next.next.next.next = new Node(16);
        node.next.next.next.next.next.next = new Node(7);
//        node.next.next.next.next.next.next.next = new Node(8);
//        node.next.next.next.next.next.next.next.next = new Node(9);

        print(node);
        node = arrayTest(node, 13);
        print(node);
    }

    public static void print(Node node) {
        System.out.println(" 打印Node");
        while (node != null) {
            System.out.print(String.format("%s ",node.value+""));
            node = node.next;
        }
        System.out.println(" ");
    }
}
