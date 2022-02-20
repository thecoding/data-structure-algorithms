package leetcode.top100;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Q21 {

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

        print(mergeTwoLists(head1, head11));
    }


    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " , ");
            head = head.next;
        }
        System.out.println();
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        // 谁小，先排序
        ListNode res = list1.val < list2.val ? list1 : list2;
        // res.next已经是较小的链表，所以下一个要用较大的链表
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);
        return res;
    }
}
