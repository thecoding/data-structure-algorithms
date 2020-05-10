package com.base;

/**
 * Created by Mirko on 2020/5/3.
 * | 按位或运算：只要有一位为1即返回1
 */
public class OrTest {


    public static void main(String[] args) {
        int a = 5,b = 6;
        orCount(a, b);
    }

    public static void orCount(int a, int b){
        System.out.println("a = " + a + " 二进制表示为：" + Integer.toBinaryString(a));
        System.out.println("b = " + b + " 二进制表示为：" + Integer.toBinaryString(b));
        System.out.println("a | b = " + (a | b) + " 二进制表示为：" + Integer.toBinaryString(a | b));
    }
}
