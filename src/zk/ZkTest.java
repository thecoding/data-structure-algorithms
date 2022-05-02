package zk;


import javax.sound.midi.Soundbank;

/**
 * 测试类
 */
public class ZkTest {

    public static void main(String[] args) {
//        int[] arr = {3,5,9,12,13};
        int[] arr = {12, 3, 13, 5, 9};
        // 初始化LinkNode
        LinkNode linkNode = new LinkNode();
        LinkNode cur = linkNode;
        for (int i = 0; i < arr.length; i++) {
            cur.value = arr[i];
            if (i < arr.length - 1) {
                LinkNode next = new LinkNode();
                cur.next = next;
                cur = cur.next;
            }
        }
        // 打印
        cur = linkNode;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();

        linkNode = new LinkNode(-1);
        for (int i = 0; i < arr.length; i++) {
            LinkNode tmp = new LinkNode(arr[i]);
            linkNode.addBySort(tmp);
        }
        linkNode = linkNode.next;

        // 按顺序加入
        System.out.println("按顺序加入...");
        cur = linkNode;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();

        linkNode = new LinkNode(-1);
        for (int i = 0; i < arr.length; i++) {
            LinkNode tmp = new LinkNode(arr[i]);
            linkNode.add(tmp);
        }
        linkNode = linkNode.next;
        System.out.println("不按顺序加入...");
        cur = linkNode;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("   ");

        linkNode.sortDesc();
        cur = linkNode;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("   ");


        linkNode.sortAsc();
        cur = linkNode;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("   ");
    }



}


class LinkNode {

    public int value;
    public LinkNode next;

    public LinkNode() {
    }

    public LinkNode(int value) {
        this.value = value;
    }

    // 对内部进行排序 降序
    public void sortDesc(){
        LinkNode pre = this;
        LinkNode cur = next;
        while (pre != null && cur != null) {
            if (pre.value < cur.value) {
                int tmp = pre.value;
                pre.value = cur.value;
                cur.value = tmp;
            }else{
                cur = cur.next;
                if (cur == null) {
                    pre = pre.next;
                    if (pre != null) {
                        cur = pre.next;
                    }
                }
            }
        }
    }

    // 升序
    public void sortAsc(){
        LinkNode pre = this;
        LinkNode cur = next;
        while (pre != null && cur != null) {
            if (cur.value < pre.value) {
                int tmp = pre.value;
                pre.value = cur.value;
                cur.value = tmp;
            }else{
                cur = cur.next;
                if (cur == null) {
                    pre = pre.next;
                    if (pre != null) {
                        cur = pre.next;
                    }
                }
            }
        }
    }

    // 删除某元素
    public void remove(int v) {

    }

    public void add(LinkNode node) {
        if (next == null) {
            next = node;
        }else{
            LinkNode tmp = next;
            while (tmp != null) {
                if (tmp.next == null) {
                    tmp.next = node;
                    break;
                }else{
                    tmp = tmp.next;
                }
            }
        }
    }

    // 增加一个节点，返回头节点，当前为头节点
    public LinkNode addBySort(LinkNode node) {
        if (node == null) {
            return this;
        }
        if (node.value < this.value) {
            node.next = this;
            return node;
        } else {
            addBySort(node, this);
        }
        return this;
    }

    private void addBySort(LinkNode node, LinkNode before) {
        if (before.next == null) {
            before.next = node;
        }else{
            if (node.value < before.next.value) {
                node.next = before.next;
                before.next = node;
            }else{
                addBySort(node, before.next);
            }
        }
    }
}