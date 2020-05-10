package com.base;

/**
 * Created by Mirko on 2020/5/3.
 * 按位与 & 运算 ： 两位同时为1才返回1
 */
public class AndTest {

    public static void main(String[] args) {
        int a = 5,b = 6;
        andCount(a, b);
        andCountThree(a,b,b);
    }

    /**
     *  这里是 a & b & c -> a & b & b = a
     * @param a int数
     * @param b int数
     * @param c int数
     */
    private static void andCountThree(int a, int b, int c) {
        System.out.println("a & b & c = " + (a & b & c) + " 二进制表示为："+ Integer.toBinaryString(a & b & c));
    }

    public static void andCount(int a, int b){
        System.out.println("a = " + a + " 二进制表示为：" + Integer.toBinaryString(a));
        System.out.println("b = " + b + " 二进制表示为：" + Integer.toBinaryString(b));
        System.out.println("a & b = " + (a & b) + " 二进制表示为：" + Integer.toBinaryString(a & b));
    }


}
