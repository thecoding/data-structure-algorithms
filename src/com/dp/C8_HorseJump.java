package com.dp;

public class C8_HorseJump {

    /**
     * 象棋从 (0,0)位置出发，到达(a,b)坐标需要step步，一共有多少中方法
     * 背景：横坐标最大为9  纵坐标最大为8
     * @param args
     */
    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(jump(x, y, step));
        System.out.println(dp(x, y, step));
    }

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

    /**
     *
     * @param x  当前横坐标x坐标
     * @param y  当前纵坐标y坐标
     * @param rest 剩下多少步
     * @param a  目标横坐标a
     * @param b  目标纵坐标b
     * @return  返回总步数
     */
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


    public static int dp(int a, int b, int rest) {
        int[][][] dp = new int[10][9][rest + 1];
        // base case  到达目标，rest = 0 则是方法的一种
        dp[a][b][0] = 1;
        // 怎么循环  -->
        for (int i = 1; i <= rest; i++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 9; y++) {
                    int ways = check(x + 1, y + 2, i - 1, dp);
                    ways += check(x + 1, y - 2, i - 1, dp);
                    ways += check(x - 1, y + 2, i - 1, dp);
                    ways += check(x - 1, y - 2, i - 1, dp);
                    ways += check(x + 2, y + 1, i - 1, dp);
                    ways += check(x + 2, y - 1, i - 1, dp);
                    ways += check(x - 2, y + 1, i - 1, dp);
                    ways += check(x - 2, y - 1, i - 1, dp);
                    dp[x][y][i] = ways;
                }
            }
        }
        return dp[0][0][rest];
    }

    private static int check(int x, int y, int rest, int[][][] dp) {
        if (x > 9 || x < 0 || y > 8 || y < 0){
            return 0;
        }
        return dp[x][y][rest];
    }

}
