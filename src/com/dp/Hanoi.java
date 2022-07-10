package com.dp;

/**
 * 汉诺塔问题
 * 子问题是：n-1从 from到other 然后other到to
 */
public class Hanoi {

    public static void main(String[] args) {
        hanoi1(3);
    }

    public static void hanoi1(int n){
        if (n > 1) {
            move(n, "from", "to", "other");
        }
    }

    public static void move(int n, String from, String to, String other) {
        if (n == 1) {
            return;
        }
        move(n - 1, from, other, to);
        move(n - 1, other, to, from);
    }
}
