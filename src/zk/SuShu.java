package zk;

import java.util.ArrayList;
import java.util.List;

/**
 * 求200-300之间的素数
 */
public class SuShu {

    public static void main(String[] args) {
        List<Integer> ss = ss(200, 300);
        ss.stream().forEach(System.out::println);

        // test2
        int[][] a = {{5, 12, 23, 56}, {19, 28, 37, 56}, {-12, -34, 6, 8}};
        System.out.println(findMax(a));
    }

    // 求二维数组中最大的数
    public static int findMax(int[][] a) {
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int[] lineArr = a[i];
            for (int j = 0; j < lineArr.length; j++) {
                if (lineArr[j] > tmp) {
                    tmp = lineArr[j];
                }
            }
        }
        return tmp;
    }

    // 求素数
    public static List<Integer> ss(int start, int end) {
        List<Integer> rtn = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == i -1) {
                    rtn.add(i);
                }
            }
        }
        return rtn;
    }
}

