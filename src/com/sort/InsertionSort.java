package com.sort;


/**
 * 插入排序
 * 从左侧已经拍好的顺序中，选择位置插入
 * 第一层从1开始，
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 7};
        int[] ints = insertSort(arr);
        print(ints);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return arr;
    }
}
