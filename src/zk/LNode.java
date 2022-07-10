package zk;


public class LNode {

    public int value;
    public LNode next;

    public LNode(int v) {
        this.value = v;
    }

    // 按顺序增加
    public LNode add(int v){
        LNode node = new LNode(v);
        if (v < this.value) {
            node.next = this;
            return node;
        }else{
            if (next == null) {
                next = node;
            }else{
                LNode cur = next;
                LNode before = this;
                if(v < cur.value){
                    before.next = node;
                    node.next = cur;
                }else{
                    cur.add(v);
                }
            }
            return this;
        }
    }

    public LNode remove(int v){
        if (v == this.value) {
            return next;
        }else{
            LNode cur = next;
            LNode before = this;
            while (cur != null) {
                if (cur.value == v) {
                    before.next = cur.next;
                    break;
                }else{
                    cur = cur.next;
                    before = before.next;
                }
            }
            return this;
        }
    }

    @Override
    public String toString() {
        String str = this.value + " ";
        LNode cur = next;
        while (cur != null) {
            str += cur.value + " ";
            cur = cur.next;
        }
        return str;
    }


    public static void main(String[] args) {
        int[] arr = {3,2,5,9,12,13};
        LNode node = new LNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            node = node.add(arr[i]);
        }
        System.out.println("初始化");
        System.out.println(node.toString());

        System.out.println("删除");
        node = node.remove(13);
        System.out.println(node);

        System.out.println("新增6");
        node = node.add(6);
        System.out.println(node);

        int i = 0;
        LNode tmp = node;
        while (tmp != null){
            tmp = tmp.next;
            i++;
        }
        System.out.println("链表长度为：" + i);
    }

}
