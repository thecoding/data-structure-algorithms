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

    //链表转数组
    public static Node arrayTest(Node head, int num){

        //遍历链表的大小
        Node n1 = head;
        int index = 0;
        while (n1 != null) {
            n1 = n1.next;
            index++;
        }

        Node[] arr = new Node[index];
        n1 = head;

        for (int i = 0; i < index; i++) {
            arr[i] = n1;
            n1 = n1.next;
        }
        //数组分区
        arrPartition(arr,num);
//        printArr(arr);

        //数组转linked
        for (int i = 1; i < arr.length; i++) {
            arr[i-1].next = arr[i];
        }
        arr[arr.length - 1].next = null;
        return arr[0];
    }

    public static void printArr(Node[] arr){
        for (Node node : arr) {
            System.out.print(String.format("%s ",node.value));
        }
        System.out.println(" ");
    }

    private static void arrPartition(Node[] arr , int pivot) {
        int small = -1;
        int big = arr.length;
        int index = 0;
        while (index != big) {
            if (arr[index].value < pivot) {
                swap(arr,++small,index++);
            } else if (arr[index].value == pivot) {
                index++;
            } else if (arr[index].value > pivot) {
                swap(arr,index,--big);
            }
        }
    }

    private static void swap(Node[] arr, int a, int b){
        Node tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }



    //通过链表实现
    //思路: 定义6个变量，左边小于的一个头结点，一个尾节点
    // 中间等于的一个头结点，一个尾节点
    // 大于的一个头节点，一个尾节点

    public static Node linkedTest(Node head,int pivot){
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equals head
        Node eT = null; // equals tail
        Node mH = null; // big head;
        Node mT = null; // big tail;

        Node n1 = null; //临时节点
        while (head != null) {
            n1 = head.next;
            head.next = null;
            if(head.value < pivot){
                if (sH == null) {
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                }else{
                    mT.next = head;
                    mT = head;
                }
            }
            head = n1;
        }
        //如果有小于区
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }


    /**
     * 将单向链表按某值划分成左边小、中间相等、右边大的形式
     * 1）把链表放入数组里，在数组上做partition（笔试用）
     * 2）分成小、中、大三部分，再把各个部分之间串起来（面试用）
     * @param args
     */
    public static void main(String[] args) {
        Node node = null;
        node = new Node(19);
        node.next = new Node(12);
        node.next.next = new Node(13);
        node.next.next.next = new Node(34);
        node.next.next.next.next = new Node(13);
        node.next.next.next.next.next = new Node(16);
        node.next.next.next.next.next.next = new Node(7);
//        node.next.next.next.next.next.next.next = new Node(8);
//        node.next.next.next.next.next.next.next.next = new Node(9);

        print(node);
//        node = arrayTest(node, 13);
        node = linkedTest(node, 7);
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
