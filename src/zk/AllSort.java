package zk;


import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

/**
 * 排序算法
 */
public class AllSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 3, 5, 6};
        int[] bubblingArr = bubblingSort(arr);
        int[] selectArr = selectSort(arr);
        System.out.println("冒泡排序");
        print(bubblingArr);
        System.out.println("选择排序");
        print(selectArr);

        int a = 90;
        System.out.println("二分查找" + a);
        int i = binarySelect(bubblingArr, a);
        System.out.println(i);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    /**
     * 冒泡排序
     * @param arr 冒泡排序
     * @return arr
     */
    public static int[] bubblingSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
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


    /**
     * 选择排序 --- 从后续数据中选择一个最小/最大的数据，放到当前位置
     * @param arr 数组
     * @return arr
     */
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cur = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[cur]) {
                    cur = j;
                }
            }
            if (cur != i) {
                int tmp = arr[i];
                arr[i] = arr[cur];
                arr[cur] = tmp;
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
        int mid = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] == a) {
                return mid;
            }else if (arr[mid] > a) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }


}
