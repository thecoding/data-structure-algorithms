package com.greed;

import java.util.HashSet;

/**
 * 有一排灯光 x表示墙，'.' 表示需要点亮的地方，并且是可以安装灯的
 * 当'.' 位置上安装了灯，就能照亮自己和左右两边的位置。
 * 要求选出能照亮所有.的方案，并且在这些有效的方案中，返回最少需要几个灯
 * class_14
 */
public class Code19_Light {

    //
    public static int minLight1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0, new HashSet<>());
    }

    public static int process(char[] str, int index, HashSet<Integer> lights) {
        if (index == str.length) { // 结束的时候
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'x') { // 当前位置是点的话
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else { // str还没结束
            // i X .
            int no = process(str, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (str[index] == '.') {
                lights.add(index);
                yes = process(str, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    // 暴力
    public static int minLight2(String string) {
        char[] chars = string.toCharArray();
        int i = 0;
        int light = 0;
        while (i < chars.length) {
            if (chars[i] == 'x') {
                i++;
            } else {
                light++;
                if (i + 1 == chars.length) {
                    break;
                }
                if (chars[i + 1] == 'x') {
                    i = i + 2;
                } else {
                    i = i + 3;
                }
            }
        }
        return light;
    }


    private static String initString(int strLen) {
        char[] chars = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Math.random() < 0.5 ? 'x' : '.';
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
//        int strLen = 10;
//        int times = 10;
//        for (int i = 0; i < times; i++) {
//            String str = initString(strLen);
//            int light = minLight2(str);
//            int light2 = minLight1(str);
//            if (light2 != light) {
//                System.out.println("str=" + str);
//                System.out.println("Oop!");
//            }
//            System.out.println("str = " + str + "  light = " + light);
//        }

        int minLight1 = minLight1("...x....x");
    }
}
