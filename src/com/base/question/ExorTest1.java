package com.base.question;

/**
 * Created by Mirko on 2020/5/4.
 *
 */
public class ExorTest1 {

    public static void main(String[] args) {
       test();
    }



    /**
     * 求数组里出现奇数个的两个数据是多少
     */
    public static void test(){
        int[] arr = {12,4,6,6,12,8,9,8,4,4};
        int xorAll = exorAll(arr);
        //取最后一位是1的
        int rightOne = xorAll & (~xorAll + 1);
        System.out.println(" rightOne = " + Integer.toBinaryString(rightOne));
        int one = 0;
        for (int j = 0; j < arr.length; j++) {
            if((rightOne & arr[j]) != 0){
                one ^= arr[j];
            }
        }
        System.out.println(" one = " + one + " and other one is " + (one ^ xorAll));
    }


    public static int exorAll(int[] a){
        int exor = 0;
        for (int i = 0; i < a.length; i++) {
            exor ^= a[i];
        }
        System.out.println(" 所有数据异或为：" + Integer.toBinaryString(exor));
        return exor;
    }
}
