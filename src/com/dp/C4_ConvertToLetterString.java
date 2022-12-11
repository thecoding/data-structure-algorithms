package com.dp;

public class C4_ConvertToLetterString {


    public static int number(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        // 怎么递归？
        // 从位置开始
        // 需要完整的数组
        return process(str.toCharArray(), 0);
    }


    public static int process(char[] chars, int index) {
        // base case 是什么？ -- 如果index走到了最后，表示之前的决定是正确的，并且返回一种方法
        if (index == chars.length) {
            return 1;
        }
        // 特殊场景 如果下一位是0，表示之前的尝试是错误的
        if (chars[index] == '0') {
            return 0;
        }
        // 当前位置选择
        int ways = process(chars, index + 1);
        // 当前位置选 + 2  最多两位数拼接，并且两位数不能大于27，字母最多是26位
        if (index + 1 < chars.length && (chars[index] - '0') * 10 + chars[index + 1] - '0' < 27) {
            ways += process(chars, index + 2);
        }
        return ways;
    }


    // 增加缓存步骤
    // 0、界限判定，什么情况下是不需要计算的
    // 1、确定dp数组：process 变量只有一个，所以是个一维数组
    // 2、依赖关系，根据process选择，都是依赖下一位，dp填充数字就是从右往左填充，也就是循环的方向
    // 3、最后返回，根据number方法返回的值，开始index的值是多少
    public static int dpProcess(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        int length = str.length();
        char[] chars = str.toCharArray();
        int[] dp = new int[length + 1];

        // base case
//        if (index == chars.length) {
//            return 1;
//        }
        // 转化成dp
        dp[length] = 1;

        for (int index = length - 1; index >= 0; index--) {
            // 剩下选择的转换成dp

            // 特殊场景转化
//            if (chars[index] == '0') {
//                return 0;
//            }

            if (chars[index] != '0') {
//            int ways = process(chars, index + 1); 转化如下
                int ways = dp[index + 1];


                // process 常规场景转化
//                if (index + 1 < chars.length && (chars[index] - '0') * 10 + chars[index + 1] - '0' < 27) {
//                    ways += process(chars, index + 2);
//                }

                if (index + 1 < chars.length && (chars[index] - '0') * 10 + chars[index + 1] - '0' < 27) {
                    ways += dp[index + 2];
                }
                dp[index] = ways;
            }

        }
        return dp[0];
    }

    public static void main(String[] args) {
        char c = '2'; // (c - '0') * 10 表示10位数的数字
        System.out.println(number("7210231231232031203123"));
        System.out.println(dpProcess("7210231231232031203123"));
    }
}
