package com.base;

/**
 * Created by Mirko on 2020/5/3.
 *  >> 右移位，高位是什么，就补什么
 */
public class ShrTest {

    public static void main(String[] args) {
        shlTest(5);
        getMidNum(2,3);
    }

    /**
     * mid = min + (max - min)/2 --> mid = min + ( max - min ) >> 1
     * @param min
     * @param max
     */
    private static void getMidNum(int min, int max) {
        System.out.println("=========================");
        System.out.println("min 二进制是：" + Integer.toBinaryString(min));
        System.out.println("max 二进制是：" + Integer.toBinaryString(max));
        System.out.println(max + " - " + min + " = " + (max - min) + " 二进制是：" + Integer.toBinaryString(max - min));
        System.out.println("min和max的中间数是："+ (min + ((max-min)>>1)) + " 二进制是：" + Integer.toBinaryString((min + ((max-min)>>1))));
    }

    public static void shlTest(int a ){
        System.out.println(" a 二进制表示为： " + Integer.toBinaryString(a));
        System.out.println(" a >> 1 表示a右移1位 " + Integer.toBinaryString( a >> 1));
        System.out.println(" " + a + " >> 1  =  " + (a >> 1));

        System.out.println(" ~a >> 1 = " + (~a >> 1) +  " 二进制表示为：" + Integer.toBinaryString(~a >> 1));
    }
}
