package zk;


import com.sort.ShellSort;

/**
 * 排序算法
 */
public class AllSort {

    public static void main(String[] args) {
        int[] arr = {3,11,14,1,6,7,9,5};
        int[] bubblingArr = bubblingSort(arr);
        int[] arr2 = {3,11,14,1,6,7,9,5};
        int[] selectArr = selectSort(arr2);
        System.out.println("冒泡排序");
        print(bubblingArr);
        System.out.println("选择排序");
        print(selectArr);
        int[] arr3 = {3,11,14,1,6,7,9,5};
        System.out.println("插入排序");
        int[] insertArr = insertSort(arr3);
        print(insertArr);

        int a = 7;
        System.out.println("二分查找" + a);
        int i = binarySelect(bubblingArr, a);
        System.out.println(i);

        a = 14;
        System.out.println("二分查找" + a);
        System.out.println(binarySelect(bubblingArr, a));

        a = 90;
        System.out.println("二分查找" + a);
        System.out.println(binarySelect(bubblingArr, a));
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static int[] bubblingSort(int[] arr) {
        for (int i=0; i<arr.length -1;i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }


    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            int tmp = i;
            for (int j = i; j < arr.length; j++){
                if(arr[tmp] > arr[j]){
                    tmp = j;
                }
            }
            if(tmp != i){
                int cur = arr[i];
                arr[i] = arr[tmp];
                arr[tmp] = cur;
            }
        }
        return arr;
    }

    public static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return arr;
    }




    /**
     * 二分查找 前提是有顺序的
     * @param arr 数组
     * @param a 需要找的值
     * @return 数字在数组中的下标
     */
    public static int binarySelect(int[] arr, int a) {
        int left=0, right = arr.length - 1, mid = -1;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if(arr[mid] == a){
                return mid;
            }else if(arr[mid] > a){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 希尔排序
     * @see ShellSort#shellSort(int[])
     * @param arr 数组
     * @return
     */
    public static int[] shellSort(int[] arr){
        return arr;
    }


    /**
     * 归并排序
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        return arr;
    }

}
