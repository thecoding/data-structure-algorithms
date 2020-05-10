package com.base;

/**
 * Created by Mirko on 2020/5/3.
 * ~ 取反
 */
public class NotTest {

    public static void main(String[] args) {
        int a = 5;
        notTest(a);
    }


    /**
     * int 存储的是4个字节，每个字节是8位，一共是32位，第一位表示符号位（1表示为负，0表示为正）
     * @param a
     */
    public static void notTest(int a){
        System.out.println(" a = " + a + " 二进制表示为：" + Integer.toBinaryString(a));
        System.out.println(" ~a = " + ~a + " 二进制表示为：" + Integer.toBinaryString(~a));
    }
}
