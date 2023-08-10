package leetcode.other;

import leetcode.top100.ListNode;

import java.util.List;

/**
 * swap-nodes-in-pairs
 */
public class Q24 {



//    public static ListNode swapExample(ListNode head){
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode prev = dummy;
//
//        while (head != null && head.next != null) {
//            ListNode first = head;
//            ListNode second = head.next;
//
//            // 交换节点
//            first.next = second.next;
//            second.next = first;
//            prev.next = second;
//
//            // 更新节点指针
//            prev = first;
//            head = first.next;
//        }
//
//        return dummy.next;
//    }


    //error
    public static ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        // 必须要有个前置节点，需要交换如果在中间，前置节点也要跟着改，不然就会断层，跟前面联系不上
        ListNode result = new ListNode(0);
        result.next = head;

        ListNode pre = result;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // first.next需要先赋值，second.next指向的是没有定义的未知位置，如果先将second.next赋值，就找不到引用了
            first.next = second.next;
            second.next = first;
            pre.next = second;

            pre = first;
            head = first.next;
        }
       return result.next;
    }


    public static ListNode swapPair4(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        swap(result, head);
        return result.next;
    }

    public static void swap(ListNode pre, ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = second.next;
        second.next = first;
        pre.next = second;

        pre = first;
        head = first.next;
        swap(pre, head);
    }







    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        print(node1);

        System.out.println("------");
        ListNode listNode1 = swapPairs(node1);
        print(listNode1);

//        ListNode listNode = swapPairs(node1);
//        System.out.println("------");
//        print(listNode);

    }

    public static void print(ListNode node) {
        ListNode tmp = node;
        System.out.println(tmp.val);
        while (tmp.next != null) {
            System.out.println(tmp.next.val);
            tmp = tmp.next;
        }
    }



    public static ListNode swapPairs3(ListNode head) {
        // 用一个 fake 节点，指向头结点，这样，头结点永远不会丢失
        ListNode fake = new ListNode(-1);
        fake.next=head;
        swapRecursion(fake,head);
        return fake.next;
    }


    public static void swapRecursion(ListNode pre,ListNode node) {
        if (node==null || node.next==null) return;
        // 交换节点
        ListNode next = node.next;
        node.next=next.next;
        next.next=node;
        pre.next=next;
        // 递归
        swapRecursion(node,node.next);
    }

}
