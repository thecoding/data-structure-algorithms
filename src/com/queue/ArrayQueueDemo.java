package com.queue;

import java.util.Scanner;

/**
 * Created by zhouchao on 2019/11/2.
 * 数组模拟队列，只是初版的，没有实现循环
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        System.out.println("a -->  add 增加数据");
        System.out.println("g -->  get 取出数据");
        System.out.println("h -->  head 头部数据");
        System.out.println("e -->  exit 退出程序");
        System.out.println("s -->  显示数据");

        Scanner scanner = new Scanner(System.in);
        boolean looper = true;
        while (looper) {
            char input = scanner.next().charAt(0);
            switch (input) {
                case 'a':
                    System.out.println("请输入一个数据");
                    int i = scanner.nextInt();
                    queue.add(i);
                    break;
                case 'g':
                    System.out.printf("取出的数据是：%d ",queue.getQueue());
                    break;
                case 'h':
                    System.out.printf("当前头部数据是：%d \n",queue.headQueue());
                    break;
                case 'e':
                    scanner.close();
                    looper = false;
                    break;
                case 's':
                    queue.showQueue();
                    break;
                default:
                    break;
            }
        }
    }
}


class ArrayQueue implements Queue{

    private int MAX_NUM = 3; //队列的最大容量
    private int front = -1; //队列头
    private int rear = -1; //队列尾
    private int[] arr; //存放数据，模拟队列

    public ArrayQueue(int MAX_NUM) {
        arr = new int[MAX_NUM];
        front = -1;
        rear = -1;
    }

    @Override
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能存储");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    @Override
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能取数据。");
            return -1;
        }
        front++;
        return arr[front];
    }

    @Override
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能取数据。");
            return -1;
        }
        return arr[front+1];
    }

    @Override
    public boolean isFull() {
        if (rear == MAX_NUM - 1) {
            System.out.println("队列已满。。");
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (front == rear) {
            System.out.println("队列为空。。");
            return true;
        }
        return false;
    }

    @Override
    public void showQueue() {
        for (int i = 0; i < MAX_NUM; i++) {
            System.out.printf("arr[%d] = %d \n", i, arr[i]);
        }
    }
}


interface Queue{
    void add(int n);
    int getQueue();
    int headQueue();
    boolean isFull();
    boolean isEmpty();
    void showQueue();
}