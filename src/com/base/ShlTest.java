package com.base;

/**
 * Created by Mirko on 2020/5/3.
 * << 左移运算，相当于原数 * 2
 */
public class ShlTest {

    public static void main(String[] args) {
        shlTest(5);
    }

    public static void shlTest(int a ){
        System.out.println(" a 二进制表示为： " + Integer.toBinaryString(a));
        System.out.println(" a << 1 表示a左移1位 " + Integer.toBinaryString( a << 1));
        System.out.println(" " + a + " << 1  =  " + (a << 1));

        System.out.println(" ~a << 1 = " + (~a << 1) +  " 二进制表示为：" + Integer.toBinaryString(~a << 1));
    }
}
