package leetcode.top100;

import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 和题目21题目相似：{@link Q21}
 */
public class Q23 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head4.next = head5;
        head3.next = head4;
        head2.next = head3;
        head1.next = head2;


        ListNode head11 = new ListNode(3);
        ListNode head12 = new ListNode(3);
        ListNode head13 = new ListNode(5);
        ListNode head14 = new ListNode(7);
        ListNode head15 = new ListNode(8);
        head14.next = head15;
        head13.next = head14;
        head12.next = head13;
        head11.next = head12;

        ListNode head21 = new ListNode(3);
        ListNode head22 = new ListNode(3);
        ListNode head23 = new ListNode(5);
        ListNode head24 = new ListNode(7);
        ListNode head25 = new ListNode(8);
        head24.next = head25;
        head23.next = head24;
        head22.next = head23;
        head21.next = head22;

        ListNode[] listNodes = {head1, head11,head21};
        ListNode[] listNodes2 = {};
//        print(mergeKLists(listNodes2));


        print(mergeKLists2(listNodes));
    }


    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " , ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode rtn = null;
        for (ListNode list : lists) {
            rtn = mergeTwoLists(rtn, list);
        }
        return rtn;
    }


    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode res = list1.val > list2.val ? list2 : list1;
        res.next = mergeTwoLists(res.next, list1.val > list2.val ? list1 : list2);
        return res;
    }


    // test2 从每个ListNode中对比，依次取出小的数来做排序
    // 这样的话，每个ListNode需要知道当前是在哪个位置

    // ListNode如何去拼接: 先创建一个列表，然后操作node -> curNode来做不断设值
    public static ListNode mergeKLists2(ListNode[] lists) {
        // 每个List当前位置
        ListNode[] indexNodes = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            indexNodes[i] = lists[i];
        }
        ListNode rtn = new ListNode();
        ListNode curNode = rtn;
        while (true) {
            int curMinInt = Integer.MAX_VALUE;
            int curIndex = -1;
            for (int i = 0; i < indexNodes.length; i++) {
                if (indexNodes[i] == null) {
                    continue;
                }
                // 第一次进来，设定一个初始值 或者是找到了当前循环中最小的值
                if (indexNodes[i].val < curMinInt) {
                    curMinInt = indexNodes[i].val;
                    curIndex = i;
                }
            }
            // 循环结束：没有找到最小值，表示整个链表结束了
            if (curIndex == -1) {
                break;
            }
            // 发现最小的值
            curNode.next = indexNodes[curIndex];
            curNode = curNode.next;
            // 当前最小值往后走一步
            indexNodes[curIndex] = indexNodes[curIndex].next;
        }
        return rtn.next;
    }
















}
