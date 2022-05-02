package com.sort;


/**
 * 选择排序
 * 从后续的数字中，选择一个最小/最大的数字 排到当前位置
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 3, 4, 6, 5};
        int[] arrAfter = select(arr);
        for (int i : arrAfter) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static int[] select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cur = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[cur]) {
                    cur = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[cur];
            arr[cur] = tmp;
        }
        return arr;
    }
}
