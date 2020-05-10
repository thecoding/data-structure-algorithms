package com.base.question;

/**
 * Created by Mirko on 2020/5/3.
 * 提取int类型最右的一个1  比如 10011000 -> 1000
 */
public class GetRightOne {

    public static void main(String[] args) {
        getRightOne(28);
    }

    public static void getRightOne(int a){
        System.out.println(" a 二进制为：" + Integer.toBinaryString(a));
        System.out.println(" ~a = " + Integer.toBinaryString(~a));
        System.out.println(" ~a + 1 = " + Integer.toBinaryString(~a + 1));
        System.out.println(" a & (~a + 1)  = " + Integer.toBinaryString(a & (~a + 1)));
    }
}
