package leetcode.top100;



/**
 * 删除链表中倒数指定节点的数据
 * 顺序：记录每个节点，从n中找到指定节点，然后删除
 * 如果是数组来记录，但是数组是固定的，不可扩容
 */
public class Q19 {

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
        print(head1);

        // 考虑方法的值传递还是引用传递，写法不一样
//        removeNthFromEnd(head1, 5); // 这种返回打印的还是原链表

        head1 = removeNthFromEnd(head1, 5); // 这种打印出来的就是返回后的对象
        print(head1);
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " , ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 极限情况的处理
     * @param head 链表
     * @param n 删除的位置
     * @return 返回原链表
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head, slowPre = null;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 边界处理
        // fast == null -> n在ListNode大小内，并且是移动到了最后一位，说明是删除第一位
        if (fast == null) return head.next;
        while (fast != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        slowPre.next = slow.next;
        return head;
    }
}
