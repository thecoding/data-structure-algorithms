package zk;


/**
 * 双向链表
 * https://www.cnblogs.com/bigsai/p/14593196.html
 */
public class DoublyLinkNode {

    Node head;
    Node last;
    int length;

    private class Node {
        public int value;
        public Node next;
        public Node pre;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkNode() {
        head = null;
        last = head;
        length = 0;
    }


    //清空链表
    public void clear(){
        head = null;
        last = head;
        length = 0;
    }

    // 获取链表长度
    public int getLength(){
        return length;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return length == 0;
    }

    // 获取第一个元素
    public Node getFirst(){
        return head;
    }
    // 获取最后一个元素
    public Node getLast(){
        return last;
    }

    public void addFirst(int t){
        Node node = new Node(t);
        addFirst(node);
    }

    public void addEnd(int t){
        Node node = new Node(t);
        addEnd(node);
    }

    // 插入元素t
    public void addFirst(Node t){
        if (isEmpty()) {
            head = t;
            last = t;
            length = 1;
        }else{
            t.next = head;
            head = t;
            length++;
        }
    }

    public void addEnd(Node t){
        if (isEmpty()) {
            head = t;
            last = t;
            length = 1;
        }else{
            last.next = t;
            t.pre = last;
            last = t;
            length++;
        }
    }

    public void insert(int i,int t){
        Node node = new Node(t);
        insert(i, node);
    }

    // 向指定位置i位置插入元素t
    public void insert(int i,Node t){
        if (i <0 ||i > length - 1) {
            return;
        }
        Node tmp = head;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }
        t.pre = tmp.pre;
        t.next = tmp;
        tmp.pre.next = t;
        tmp.pre = t;
        length++;
    }

    // 获取指定位置i处的元素
    public Node get(int i){
        if (i < 0 || i > length - 1) {
            return null;
        }
        Node tmp = head;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    // 找到元素t第一次出现的位置
    public int indexOf(Node t){
        Node tmp = head;
        for (int j = 0; j < length -1; j++) {
            if (tmp.value == t.value) {
                return j;
            }
            tmp = tmp.next;
        }
        return -1;
    }


    // 删除位置i处的元素,并返回该元素
    public Node remove(int i){
        Node tmp = head;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }
        tmp.pre.next = tmp.next;
        tmp.next.pre = tmp.pre;
        return tmp;
    }

    @Override
    public String toString() {
        Node team = head;
        String vaString = "正序：";
        while (team != null) {
            vaString += team.value + " ";
            team = team.next;
        }
        vaString += " 目前节点个数为：" + length;
        vaString += " 倒序：";
        team = last;
        while (team != null) {
            vaString += team.value + " ";
            team = team.pre;
        }
        return vaString;
    }



    public static void main(String[] args) {
        int[] arr = {3,5,9,12,13};
        DoublyLinkNode doublyLinkNode = new DoublyLinkNode();
        for (int i = 0; i < arr.length; i++) {
//            doublyLinkNode.addFirst(arr[i]);
            doublyLinkNode.addEnd(arr[i]);
        }

        doublyLinkNode.insert(2,4);
        System.out.println(doublyLinkNode.toString());

        Node remove = doublyLinkNode.remove(3);
        System.out.println("被删除的节点是" + remove.value);

        System.out.println(doublyLinkNode.toString());
    }
}
