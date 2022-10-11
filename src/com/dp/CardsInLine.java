package com.dp;

public class CardsInLine {

    public static void main(String[] args) {
        int[] arr = { 5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7 };


        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }

    // 暴力递归
    private static int win1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int first = f2(arr, 0, arr.length - 1);
        int second = g2(arr, 0, arr.length - 1);
        System.out.println("first = " + first);
        System.out.println("second = " + second);
        return Math.max(first,second);
    }

    private static int f2(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int p1 = arr[l] + g2(arr, l + 1, r);
        int p2 = arr[r] + g2(arr, l, r - 1);
        return Math.max(p1, p2);
    }

    private static int g2(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int p1 = f2(arr, l + 1, r);
        int p2 = f2(arr, l, r - 1);
        return Math.min(p1, p2);
    }

    // 增加计算缓存
    private static int win2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fArr = new int[N][N];
        int[][] gArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fArr[i][j] = -1;
                gArr[i][j] = -1;
            }
        }
        int first = f2(arr, 0, arr.length - 1, fArr, gArr);
        int second = g2(arr, 0, arr.length - 1, fArr, gArr);
        return Math.max(first, second);
    }

    private static int f2(int[] arr, int L, int R, int[][] fArr, int[][] gArr) {
        if (L == R) {
            return arr[L];
        }
        if (fArr[L][R] == -1) {
            int first = arr[L] + g2(arr, L + 1, R, fArr, gArr);
            int second = arr[R] + g2(arr, L, R - 1, fArr, gArr);
            fArr[L][R] = Math.max(first, second);
        }
        return fArr[L][R];
    }

    private static int g2(int[] arr, int L, int R, int[][] fArr, int[][] gArr) {
        if (L == R) {
            return arr[R];
        }
        if (gArr[L][R] == -1) {
            int first = f2(arr, L + 1, R, fArr, gArr);
            int second = f2(arr, L, R - 1, fArr, gArr);
            gArr[L][R] = Math.min(first, second);
        }
        return gArr[L][R];
    }

    // 难点：从 win2 过渡到 win3 需要从win2中抽离，而且是通过二维数组构建，需要有一定的思维能力
    // 该方法在原方法中抽离 win2 中 f2 g2中看到具体的值是从怎么来的
    // g -> f2(arr, L + 1, R, fArr, gArr); ->  fArr[L + 1][R]
    // g -> f2f2(arr, L, R - 1, fArr, gArr); ->  fArr[L][R - 1]
    private static int win3(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fArr = new int[N][N];
        int[][] gArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            fArr[i][i] = arr[i];
        }
        for (int start = 1; start < N; start++) {
            int L = 0;
            int R = start;
            while (R < N) {
                fArr[L][R] = Math.max(arr[L] + gArr[L + 1][R], arr[R] + gArr[L][R - 1]);
                gArr[L][R] = Math.min(fArr[L + 1][R], fArr[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fArr[0][N - 1], gArr[0][N - 1]);
    }

}
