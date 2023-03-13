package com.dp;


/**
 * 模型
 * 样本尝试：特别需要讨论结尾如何
 * 范围模型：需要讨论开头如何、结尾如何
 * 从左往右：
 * 业务显示模型：
 * 空间压缩  --> 根据依赖关系、模型观察
 * 公共子序列：Input: text1 = "abcde", text2 = "ace"
 * Output: 3   eg:  ace
 * @see <a href=https://leetcode.com/problems/longest-common-subsequence/>leetCode</a>
 */
public class C6_LongestCommonSubsequence {


    public static void main(String[] args) {
        String str1 = "abcccassdc";
        String str2 = "jjlcdaasc";
        System.out.println(longestCommonSubsequence(str1, str2));
        System.out.println(longestCommonSubsequence2(str1, str2));
        System.out.println(dp(str1, str2));
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        return process1(str1Arr, str2Arr, str1Arr.length - 1, str2Arr.length - 1);
    }

    private static int process1(char[] str1Arr, char[] str2Arr, int i, int j) {
        if (i == 0 && j == 0) {
            return str1Arr[i] == str2Arr[j] ? 1 : 0;
        } else if (i == 0) {
            if (str1Arr[i] == str2Arr[j]) {
                return 1;
            }else{
                return process1(str1Arr, str2Arr, i, j - 1);
            }
        } else if (j == 0) {
            if (str1Arr[i] == str2Arr[j]) {
                return 1;
            }else{
                return process1(str1Arr, str2Arr, i - 1, j);
            }
        }else{
            int p1 = process1(str1Arr, str2Arr, i - 1, j);
            int p2 = process1(str1Arr, str2Arr, i, j - 1);
            int p3 = str1Arr[i] == str2Arr[j] ? (1 + process1(str1Arr, str2Arr, i - 1, j - 1)) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }


    public static int dp(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[][] dp = new int[char1.length][char2.length];
        for (int i = 0; i < char1.length; i++) {
            dp[i][0] = char1[i] == char2[0] ? 1 : 0;
        }
        for (int i = 0; i < char2.length; i++) {
            dp[0][i] = char1[0] == char2[i] ? 1 : 0;
        }
        // 循环该怎么走？
        for (int i = 1; i < char1.length; i++) {
            for (int j = 1; j < char2.length; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = char1[i] == char2[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[char1.length - 1][char2.length - 1];
    }

















    public static int longestCommonSubsequence2(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int[][] dp = new int[str1Arr.length][str2Arr.length];

        for (int i = 0; i < str1Arr.length; i++) {
            dp[i][0] = str1Arr[i] == str2Arr[0] ? 1 : 0;
        }
        for (int i = 0; i < str2Arr.length; i++) {
            dp[0][i] = str1Arr[0] == str2Arr[i] ? 1 : 0;
        }

        for (int i = 1; i < str1Arr.length; i++) {
            for (int j = 1; j < str2Arr.length; j++) {
                int p1 = dp[i-1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1Arr[i] == str2Arr[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[str1Arr.length - 1][str2Arr.length - 1];
    }


}
