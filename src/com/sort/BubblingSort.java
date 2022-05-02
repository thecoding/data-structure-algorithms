package com.sort;


/**
 * 冒泡排序
 * 时间复杂度为O(n2)
 * 首先是 1、2 比较，然后是 2、3比较，依次比较。。
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 3, 4, 6, 5};
        int[] bubbling = bubbling(arr);
        for (int i : bubbling) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static int[] bubbling(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
