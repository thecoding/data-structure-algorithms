package zk;


/**
 * 排序算法
 */
public class AllSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 3, 5, 6};
        int[] ints = bubblingSort(arr);
        print(ints);

        int i = binarySelect(ints, 3);
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
        return arr;
    }


    /**
     * 选择排序 --- 从后续数据中选择一个最小/最大的数据，放到当前位置
     * @param arr 数组
     * @return arr
     */
    public static int[] selectSort(int[] arr) {
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
        return mid;
    }


}
