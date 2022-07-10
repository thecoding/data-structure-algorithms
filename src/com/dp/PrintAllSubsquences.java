package com.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印全部子序列：不能置换顺序，单个或者全部都是子序列
 * abc -> a ab abc b bc c
 */
public class PrintAllSubsquences {

    public static void main(String[] args) {
        String a = "abc";
        List<String> print = print(a);
        print.forEach(System.out::println);
    }

    public static List<String> print(String str){
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        String path = "";
        process1(chars, 0, ans, path);
        return ans;
    }

    private static void process1(char[] chars, int index, List<String> ans, String path) {
        if (index == chars.length) {
            ans.add(path);
            return;
        }
        // 都不取数
        process1(chars, index + 1, ans, path);
        // 都取数
        process1(chars, index + 1, ans, path + String.valueOf(chars[index]));
    }

}
