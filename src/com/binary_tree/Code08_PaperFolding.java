package com.binary_tree;

/**
 * 题目：请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。
 * 此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。 如果从纸条的下边向上方连续对折2次，
 * 压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。 请从上到下打印所有折痕的方向。
 * 例如:N=1时，打印: down N=2时，打印: down down up
 *
 * 规律：如果以第一次节点的折痕为头节点，左边节点的头节点是凹节点，右边节点为凸节点
 * Created by Mirko on 2021/2/9.
 */
public class Code08_PaperFolding {


    public static void process(int n) {
        process(1, n, true);
    }

    private static void process(int i, int n, boolean b) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.print(" " + (b ? "凹" : "凸"));
        process(i + 1, n, false);
    }


    public static void main(String[] args) {
        process(5);
    }

}
