package com.heap;

public class Heap {

    // 大根堆，通过数组实现
    public static class MyMaxHeap {

        // 堆的容量
        private int capacity;
        private int[] heap;
        private int currSize;

        // 初始化堆
        public MyMaxHeap(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.currSize = 0;
        }

        // 是否已经满了
        public boolean isFull(){
            return currSize == capacity;
        }

        // 是否是空的
        public boolean isEmpty(){
            return currSize == 0;
        }

        // 弹出堆中最大的 -> 第一个
        public int pop(){
            int ans = heap[0];
            swap(heap, 0, --currSize);
            heapify(heap, 0);
            return ans;
        }

        private void heapify(int[] heap, int index) {
            int left = index * 2 + 1;
            while (left < currSize) {
                int largest = left + 1 < currSize && heap[left + 1] > heap[left] ? left + 1 : left;
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(heap, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        // 增加一个元素
        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException(" heap is full");
            }
            heap[currSize] = value;
            heapInsert(heap, currSize);
        }

        // 往上去比较自己的父节点
        private void heapInsert(int[] heap, int index) {
            while (heap[index] - heap[(index - 1) / 2] > 0) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
            currSize++;
        }

        public static void swap(int[] heap, int currSize, int i) {
            int value = heap[currSize];
            heap[currSize] = heap[i];
            heap[i] = value;
        }

        public static void main(String[] args) {
//            int[] heap = new int[2];
//            heap[0] = 1;
//            heap[1] = 2;
//            swap(heap, 0, 1);
//            for (int i : heap) {
//                System.out.println(i);
//            }

            MyMaxHeap myMaxHeap = new MyMaxHeap(10);
            myMaxHeap.push(0);
            myMaxHeap.push(1);
            myMaxHeap.push(2);
            myMaxHeap.push(3);
            myMaxHeap.push(4);
            myMaxHeap.push(5);
            myMaxHeap.push(6);
            myMaxHeap.push(7);
            myMaxHeap.push(8);
            myMaxHeap.push(9);
//            myMaxHeap.push(10);
//            myMaxHeap.push(11);

            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
            System.out.println(myMaxHeap.pop());
        }

    }
}
