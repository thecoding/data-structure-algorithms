package zk;


/**
 * 顺序单链表
 * 支持新增，删除
 */
public class SortLinkNode {

    private int value;
    private SortLinkNode nextNode;

    public SortLinkNode() {
    }

    public SortLinkNode(int value) {
        this.value = value;
    }


    /**
     * 增加一个节点
     * @param node 增加的节点
     * @return 返回头节点
     */
    public SortLinkNode add(SortLinkNode node) {
        if (node.value <= value) {
            node.nextNode = this;
            return node;
        }else{
            // 当前节点的下一个节点是否为空，如果为空就放在后面
            if (nextNode == null) {
                this.nextNode = node;
            }else{
                // 增加一个节点，上一个节点指向当前节点，当前节点指向下一个节点
                SortLinkNode cur = nextNode;
                cur.add(node, this);
            }
            return this;
        }
    }

    private void add(SortLinkNode node, SortLinkNode before) {
        if (before.nextNode != null) {
            if (node.value <= before.nextNode.value) {
                node.nextNode = before.nextNode;
                before.nextNode = node;
            }else{
                add(node, before.nextNode);
            }
        }else{
            before.nextNode = node;
        }
    }


    /**
     * 根据value删除一个节点，返回头节点
     * @param value 需要删除的节点
     * @return 头节点
     */
    public SortLinkNode remove(int value) {
        if(this.value == value){
            return this.nextNode;
        }else{
            // 拿到当前节点的引用
            SortLinkNode before = this;
            SortLinkNode cur = this.nextNode;
            while (cur != null) {
                if(cur.value == value){
                    before.nextNode = cur.nextNode;
                    break;
                }else{
                    before = cur;
                    cur = cur.nextNode;
                }
            }
        }
        return this;
    }


    public static void main(String[] args) {
        int[] arr = {3,5,9,12,13};
        SortLinkNode linkNode = new SortLinkNode();
        SortLinkNode cur = linkNode;
        for (int i = 0; i < arr.length; i++) {
            cur.value = arr[i];
            if (i < arr.length - 1) {
                SortLinkNode next = new SortLinkNode();
                cur.nextNode = next;
                cur = cur.nextNode;
            }
        }

        cur = linkNode;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.nextNode;
        }
        System.out.println();


        SortLinkNode addNode = new SortLinkNode(2);
        linkNode = linkNode.add(addNode);
        cur = linkNode;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.nextNode;
        }
        System.out.println();


        linkNode = linkNode.remove(50);
        cur = linkNode;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.nextNode;
        }
        System.out.println();

    }
}
