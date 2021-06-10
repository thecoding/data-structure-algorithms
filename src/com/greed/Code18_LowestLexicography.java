package com.greed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 给定一个由字符串组成的数组strs
 * 必须吧所有的字符传拼接起来，返回所有可能的拼接结果
 * 字典序最小的结果
 */
public class Code18_LowestLexicography {



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


    //暴力
    // 1、生成随机的字符串数组、字符串长度随机
    // 2、将所有的数据先排序，在组成字符串返回

    // 生成随机数组
    private static String[] generateRandomStringArray(int arrLen, int strLen){
        int length = (int) (Math.random() * arrLen + 1);
        String[] str = new String[length];
        for (int i = 0; i < length; i++) {
            str[i] = generateRandomString(strLen);
        }
        return str;
    }

    // 随机生成 65-90 97-122 的数字 中间相差25
    private static String generateRandomString(int strLen) {
        int length = (int)(Math.random() * strLen + 1);
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            int value = (int)(Math.random() * 25 + 1);
            chars[i] = (Math.random() <= 0.5) ? (char)(65 + value) : (char)(97 + value);
        }
        return String.valueOf(chars);
    }

    private static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    private static String lowestString2(String[] strs){
        if(strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            str.append(strs[i]);
        }
        return str.toString();
    }

    private static String[] copyString(String[] str1) {
        String[] ans = new String[str1.length];
        for (int i = 0; i < str1.length; i++) {
            ans[i] = str1[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int arrLen = 3;
        int strLen = 4;
        int times = 10000;
        for (int i = 0; i < times; i++) {
            String[] str1 = generateRandomStringArray(arrLen, strLen);
            String[] str2 = copyString(str1);
            if (!lowestString1(str1).equals(lowestString2(str2))) {
                System.out.println("str1" + Arrays.toString(str1));
                System.out.println("str2" + Arrays.toString(str2));
                System.out.println("Oop!");
            }
        }
        System.out.println("finish!!");
    }



}
