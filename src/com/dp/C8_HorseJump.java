package com.dp;

public class C8_HorseJump {


    /**
     * 前提：不能跳出棋盘  即： 0 <= x <= 9 0 <= y <= 9
     * @param a 目的坐标x
     * @param b 目的坐标y
     * @param k 一共多少步
     * @return 总共的方法
     */
    public static int jump(int a, int b, int k) {
        return process(0, 0, k, a, b);
    }

    public static int process(int x, int y, int rest, int a, int b) {
        if (x > 9 || x < 0 || y > 8 || y < 0) {
            return 0;
        }
        if (rest == 0) {
            // base case
            return (x == a && y == b ? 1 : 0);
        }
        int p1 = process(x + 1, y + 2, rest - 1, a, b);
        int p2 = process(x + 1, y - 2, rest - 1, a, b);
        int p3 = process(x - 1, y + 2, rest - 1, a, b);
        int p4 = process(x - 1, y - 2, rest - 1, a, b);
        int p5 = process(x + 2, y + 1, rest - 1, a, b);
        int p6 = process(x + 2, y - 1, rest - 1, a, b);
        int p7 = process(x - 2, y + 1, rest - 1, a, b);
        int p8 = process(x - 2, y - 1, rest - 1, a, b);
        return p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;
    }
}
