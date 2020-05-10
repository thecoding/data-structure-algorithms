package com.base;

/**
 * Created by Mirko on 2020/5/3.
 * ^ 异或 ->  不进位加法，两个一样的数异或是0
 */
public class XorTest {


    public static void main(String[] args) {
        int a = 5; int b = 6;
        xorTwoAsSame(4,4);
        swap(a,b);
    }

    public static void xorTwoAsSame(int a, int b){
        System.out.println("a = " + a + ", b = " + b + " and a ^ b = " + (a ^ b));
    }

    /**
     * 两个数交换，不用其他变量
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + " 二进制表示：" + Integer.toBinaryString(a));
        System.out.println("b = " + b + " 二进制表示：" + Integer.toBinaryString(b));
    }

}
