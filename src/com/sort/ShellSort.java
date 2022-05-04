package com.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author Mirko
 * @Description
 * @createTime 2021年03月25日 23:09:00
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {19,14,23,1,68,20,84,27,55,11,10,79,12};
        Arrays.stream(arr).forEach(v -> {
            System.out.print(v + ",");
        });
        System.out.println("");
       shellSort(arr);
        Arrays.stream(arr).forEach(v -> {
            System.out.print(v + ",");
        });
    }


    public static int[] shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        int k = 0;
//        int step = 1;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;


                System.out.print("第" + k++ + "次运行 ：");
                Arrays.stream(arr).forEach(v -> {
                    System.out.print(v + ",");
                });
                System.out.println("");
            }
        }
        return arr;
    }
}
