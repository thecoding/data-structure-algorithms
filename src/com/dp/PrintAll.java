package com.dp;


import java.util.ArrayList;
import java.util.List;

/**
 * 打印全部排列
 * abcd -> abcd  abdc acbd acdb
 */
public class PrintAll {

    public static void main(String[] args) {
        List<String> abcd = print1("abcd");
        abcd.forEach(System.out::println);

        System.out.println("----------");
        List<String> abccc = process2("abccc");
        abccc.forEach(System.out::println);
    }

    public static List<String> print1(String str) {
        if (str.length() <= 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        process1(chars, 0, ans);
        return ans;
    }

    // index 表示当前位置固定，后续自由排列 -- 怎么在子问题中展现
    private static List<String> process1(char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            ans.add(String.valueOf(chars));
        }else{
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                process1(chars, index + 1, ans);
                swap(chars, index, i);
            }
        }
        return ans;
    }


    public static List<String> process2(String str) {
        if (str.length() <= 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        process2(chars, 0, ans);
        return ans;
    }

    private static List<String> process2(char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            ans.add(String.valueOf(chars));
        }else{
            boolean[] visited = new boolean[256];
            for (int i = index; i < chars.length; i++) {
                if(!visited[chars[i]]){
                    visited[chars[i]] = true;
                    swap(chars, index, i);
                    process2(chars, index + 1, ans);
                    swap(chars, index, i);
                }
            }
        }
        return ans;
    }

    private static void swap(char[] chars, int index, int otherIndex) {
        char tmp = chars[index];
        chars[index] = chars[otherIndex];
        chars[otherIndex] = tmp;
    }


}
