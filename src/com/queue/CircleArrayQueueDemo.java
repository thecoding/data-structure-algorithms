package com.queue;

/**
 * Created by Mirko on 2019/12/4.
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        Queue queue = new CircleArray(3); //有效数据只有2 因为一个空间作为约定为空
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

//        System.out.println("a -->  add 增加数据");
//        System.out.println("g -->  get 取出数据");
//        System.out.println("h -->  head 头部数据");
//        System.out.println("e -->  exit 退出程序");
//        System.out.println("s -->  显示数据");
//
//        Scanner scanner = new Scanner(System.in);
//        boolean looper = true;
//        while (looper) {
//            char input = scanner.next().charAt(0);
//            switch (input) {
//                case 'a':
//                    System.out.println("请输入一个数据");
//                    int i = scanner.nextInt();
//                    queue.add(i);
//                    break;
//                case 'g':
//                    System.out.printf("取出的数据是：%d ",queue.getQueue());
//                    break;
//                case 'h':
//                    System.out.printf("当前头部数据是：%d \n",queue.headQueue());
//                    break;
//                case 'e':
//                    scanner.close();
//                    looper = false;
//                    break;
//                case 's':
//                    queue.showQueue();
//                    break;
//                default:
//                    break;
//            }
//        }
    }
}

class CircleArray implements Queue{
    private int maxSize; //数组的最大容量

    private int front; //指向数组的第一个元素

    private int rear; //队列尾

    private int[] arr; //该数据用于存放数据

    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    @Override
    public void add(int n) {
        if (isFull()) {
            System.out.println("已经存满，不能再存了");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    @Override
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能取");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    @Override
    public int headQueue() {
        return arr[front];
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public void showQueue() {
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d \n" , i % maxSize, arr[i % maxSize]);
        }
        System.out.printf("front = %d, rear = %d ", front, rear);
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
}


