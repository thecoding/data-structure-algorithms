package com.dp;

public class Knapsack {

    /**
     * 求最大价值
     * @param w 重量
     * @param v 价值
     * @param bag 重量限制
     * @return w且v全部都是正数， w.length = v.length 并且 bag > 0
     */
    public static int maxValue(int[] w, int[] v, int bag) {
        if (null == w || null == v || w.length != v.length || bag <= 0) {
            return 0;
        }
        return process(w, v, 0, bag);
    }

    private static int process(int[] w, int[] v, int index, int bag) {
        if (bag < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p0 = process(w, v, index + 1, bag);
        int p1 = 0;
        int next = process(w, v, index + 1, bag - w[index]);
        if (next != -1) {
            p1 = v[index] + next;
        }
        return Math.max(p0, p1);
    }

    private static int dp(int[] w, int[] v, int bag) {
        if (null == w || null == v || w.length != v.length || bag <= 0) {
            return 0;
        }
        int N = w.length;
        // 如何构建缓存，之间关系是什么
//         行：重量
//         列：还剩多少重量
//         v为arr具体的值
        int[][] arr = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 2 };
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
//        System.out.println(dp(weights, values, bag));
    }

}
