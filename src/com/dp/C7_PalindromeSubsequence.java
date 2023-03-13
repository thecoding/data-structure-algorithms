package com.dp;


/**
 *  测试链接：
 *  @see <a href=https://leetcode.com/problems/longest-palindromic-subsequence/></a>
 *  字符串的最长回文
 *  Input: s = "bbbab"
 *  Output: 4  eg: bbbb
 */
public class C7_PalindromeSubsequence {

    public static void main(String[] args) {
        System.out.println(process1("bcdcb"));
        System.out.println(process2("bcdcb"));
    }

    public static int process1(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        return f(str.toCharArray(), 0, str.length() - 1);
    }

    private static int f(char[] chars, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return chars[L] == chars[R] ? 2 : 1;
        }
        int p1 = f(chars, L, R - 1);
        int p2 = f(chars, L + 1, R);
        int p3 = f(chars, L + 1, R - 1);
        int p4 = chars[L] == chars[R] ? (2 + f(chars,L + 1, R - 1)) : 0;
        return Math.max(p1, Math.max(p2, Math.max(p3, p4)));
    }

    public static int process2(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        int N = str.length();
        char[] chars = str.toCharArray();
        int[][] dp = new int[N][N];
        dp[N-1][N-1] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][i] = 1;
            dp[i][i-1] = chars[i] == chars[i-1] ? 2 : 1;
        }
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
                if (chars[L] == chars[R]) {
                    dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }

    public static int dp(String string) {
        return -1;
    }
}
