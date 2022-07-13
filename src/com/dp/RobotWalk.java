package com.dp;



/**
 * 假设有排成一行的N个位置记为1~N，N一定大于或等于2
 * 开始时机器人在其中的M位置上(M一定是1~N中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到N-1位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数
 */
public class RobotWalk {

    public static void main(String[] args) {
        System.out.println(way1(10, 2, 4, 4));
        System.out.println(way2(10, 2, 4, 4));
    }


    /**
     * @param n 一共多少个位置
     * @param s 初始位置
     * @param k 多少步
     * @param p 目的位置
     * @return 一共有多少条路径 -1 为没有
     */
    public static int way1(int n, int s, int k, int p) {
        if (n < 2 || s > n || s < 1 || k < 1 || p > n || p < 1) {
            return -1;
        }
        return process1(n, s, k, p);
    }

    private static int process1(int n, int cur, int k, int des) {
        if (k == 0) {
            return cur == des ? 1 : 0;
        }
        if (cur == 1) {
            return process1(n, cur + 1, k - 1, des);
        }
        if (cur == n) {
            return process1(n, cur - 1, k - 1, des);
        }
        return process1(n, cur + 1, k - 1, des) + process1(n, cur - 1, k - 1, des);
    }

    /**
     * @param n 一共多少个位置
     * @param s 初始位置
     * @param k 多少步
     * @param p 目的位置
     * @return 一共有多少条路径 -1 为没有
     */
    public static int way2(int n, int s, int k, int p) {
        if (n < 2 || s > n || s < 1 || k < 1 || p > n || p < 1) {
            return -1;
        }
        int[][] dp = new int[s+1][k+1];
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(dp,n, s, k, p);
    }

    private static int process2(int[][] dp, int n, int cur, int k, int des) {
        if (dp[cur][k] != -1) {
            return dp[cur][k];
        }
        int ans = 0;
        if (k == 0) {
            ans = cur == des ? 1 : 0;
        }else if (cur == 1) {
            ans = process1(n, cur + 1, k - 1, des);
        }else if (cur == n) {
            ans = process1(n, cur - 1, k - 1, des);
        }else{
            ans = process1(n, cur + 1, k - 1, des) + process1(n, cur - 1, k - 1, des);
        }
        dp[cur][k] = ans;
        return ans;
    }
}
