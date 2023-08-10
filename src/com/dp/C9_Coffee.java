package com.dp;


// 题目
// 数组arr代表每一个咖啡机冲一杯咖啡的时间，每个咖啡机只能串行的制造咖啡。
// 现在有n个人需要喝咖啡，只能用咖啡机来制造咖啡。
// 认为每个人喝咖啡的时间非常短，冲好的时间即是喝完的时间。
// 每个人喝完之后咖啡杯可以选择洗或者自然挥发干净，只有一台洗咖啡杯的机器，只能串行的洗咖啡杯。
// 洗杯子的机器洗完一个杯子时间为a，任何一个杯子自然挥发干净的时间为b。
// 四个参数：arr, n, a, b
// 假设时间点从0开始，返回所有人喝完咖啡并洗完咖啡杯的全部过程结束后，至少来到什么时间点。
public class C9_Coffee {

    // arr 每一个咖啡机冲一杯咖啡的时间
    // n 表示多少人需要喝咖啡
    // a 机器洗杯子需要多久
    // b 自然挥发需要多久
    public int makeTime1(int[] arr, int n, int a, int b) {

        // 洗杯子跟冲咖啡时间是否相冲突呢？

        // 当前需要冲洗的杯子

        // 制作咖啡的时间
        int mTime = arr[0];

        // 洗杯子时间   a 需要等待 当前是0，洗完应该是a-0 = a
        int plan1 = a; // 串行
        int plan2 = b; // 并行

        // 后续人的时间
        int lastTime = makeTime2(arr, a, b, 1, 0);

        // 求min

        // 一边冲咖啡，一边喝，

        return arr[0] + makeTime2(arr, a, b, 1, 0);
    }


    // 返回最后的时间点
    // 递归，只算当前杯，需要什么元素？
    public int makeTime2(int[] arr, int a, int b, int index, int wait) {
        if (index == arr.length) {
            return 0;
        }
        // 怎么洗杯子？  咖啡制作 跟 等待时间可以是并行的？
        // 机器洗？ 时间 = Max(等待时间 , 咖啡制作时间) + a
        int p1 = Math.max(wait, arr[index]) + a;
        int p1Last = makeTime2(arr, a, b, index + 1, p1);

        // 自然挥发?  时间 = Max(咖啡制作时间 + b, 等待时间)
        int p2 = Math.max(arr[index] + b , wait);
        int p2Last = makeTime2(arr, a, b, index + 1, p2);

        int total = Math.min(p1Last, p2Last);
        return total;
    }





    public static void main(String[] args) {
//        int len = 10;
//        int max = 10;
//        int testTime = 10;
//        System.out.println("测试开始");
//        for (int i = 0; i < testTime; i++) {
//            int[] arr = randomArray(len, max);
//            int n = (int) (Math.random() * 7) + 1;
//            int a = (int) (Math.random() * 7) + 1;
//            int b = (int) (Math.random() * 10) + 1;
//            int ans1 = right(arr, n, a, b);
//            int ans2 = minTime1(arr, n, a, b);
//            int ans3 = minTime2(arr, n, a, b);
//            if (ans1 != ans2 || ans2 != ans3) {
//                printArray(arr);
//                System.out.println("n : " + n);
//                System.out.println("a : " + a);
//                System.out.println("b : " + b);
//                System.out.println(ans1 + " , " + ans2 + " , " + ans3);
//                System.out.println("===============");
//                break;
//            }
//        }
//        System.out.println("测试结束");
    }
}
