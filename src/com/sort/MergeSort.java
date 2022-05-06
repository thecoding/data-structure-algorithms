package com.sort;


import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {19,14,23,1,68,20,84,27,55,11,10,79,12};
        int[] tmpArr = new int[arr.length];
        sort(arr, tmpArr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(v -> {
            System.out.print(v + " ");
        });
    }

    public static void sort(int[] arr, int[] tmpArr, int start, int end){
        if (end <= start) {
            return;
        }
        // 中间位置
        int mid = start + ((end - start) >> 1);
        sort(arr, tmpArr, 0, mid);
        sort(arr, tmpArr, mid + 1, end);

        merge(arr, tmpArr, start, mid, end);
    }

    /**
     * 归并
     * @param arr 排序数组
     * @param tmpArr 临时数组
     * @param start 开始位置
     * @param mid 中间位置
     * @param end 结束位置
     */
    private static void merge(int[] arr, int[] tmpArr, int start, int mid, int end) {
        // 复制
        for (int i = start; i <= end; i++) {
            tmpArr[i] = arr[i];
        }
        int left = start; // 左边首位下标
        int right = mid + 1; // 右边首位下标
        for (int i = start; i <= end; i++) {
            if (left > mid) {
                // 如果左边的首位下标大于中部下标，证明左边的数据已经排完了
                arr[i] = tmpArr[right++];
            } else if (right > end) {
                //如果右边的首位下标大于了数组长度，证明右边的数据已经排完了。
                arr[i] = tmpArr[left++];
            } else if (tmpArr[right] < tmpArr[left]) {
                //将右边的首位排入，然后右边的下标指针+1。
                arr[i] = tmpArr[right++];
            } else {
                //将左边的首位排入，然后左边的下标指针+1。
                arr[i] = tmpArr[left++];
            }
        }
    }


    private static void merge2(int[] arr, int[] tmpArr, int start, int mid, int end) {
        int l = start;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) {
                tmpArr[t++] = arr[l++];
            }else{
                tmpArr[t++] = arr[r++];
            }
        }
        while (l <= mid) {
            tmpArr[t++] = arr[l++];
        }
        while (r <= end) {
            tmpArr[t++] = arr[r++];
        }
        t = 0;
        while (start <= end) {
            arr[start++] = tmpArr[t++];
        }
    }

}
