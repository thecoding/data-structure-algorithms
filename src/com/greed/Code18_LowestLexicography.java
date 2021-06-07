package com.greed;

import java.util.TreeSet;

/**
 * 给定一个由字符串组成的数组strs
 * 必须吧所有的字符传拼接起来，返回所有可能的拼接结果
 * 字典序最小的结果
 */
public class Code18_LowestLexicography {

    public static void main(String[] args) {
        String[] a = {"b","ab","cc"};
        System.out.println(lowestString1(a));
    }

    public static String lowestString1(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }
        TreeSet<String> treeSet = process(strs);
        return treeSet.size()>0 ? treeSet.first() : "";
    }

    // 返回字符串所有组合
    private static TreeSet<String> process(String[] strs) {
        TreeSet<String> ans = new TreeSet<>();
        if (strs == null || strs.length == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 0; i < strs.length; i++) {
            String first = strs[i];
            String[] other = removeIndex(strs, i);
            TreeSet<String> otherArr = process(other);
            for (String s : otherArr) {
                ans.add(first + s);
            }
        }
        return ans;
    }

    // 删除指定角标的字符串
    private static String[] removeIndex(String[] arr, int index) {
        int N = arr.length;
        String[] newArr = new String[N - 1];
        int newIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[newIndex++] = arr[i];
            }
        }
        return newArr;
    }


}
