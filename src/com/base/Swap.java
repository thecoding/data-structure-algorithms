package com.base;

/**
 * 交换的技巧
 */
public class Swap {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        swap2(arr, 0, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 将arr中的两个数字置换
    // 使用额外空间
    private static void swap1(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void swap2(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
