package lagou.module1;

import java.util.Stack;

/**
 * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i]
 * 表示鱼的方向 （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 *
 * 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 * 当方向相对时，大鱼会吃掉小鱼；
 * 鱼的大小都不一样。
 * 请完成以下接口来计算还剩下几条鱼？
 *
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
 *
 * 输出：3
 *
 * 使用单调栈
 */
public class FishEat {

    public static void main(String[] args) {
        // size表示鱼的大小
        int[] size = {4, 3, 2, 1,5};
        // dir表示鱼的方向 0为左，1为右
        int[] dir = {0, 1, 0, 0, 0};
        System.out.println(solution(size, dir));
    }

    public static int solution(int[] size, int[] dir){
        if (size.length <= 1) {
            return size.length;
        }
        final int left = 0;
        final int right = 1;
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < size.length; i++) {
            // 满足条件
            boolean hasEat = false;
            while (!t.isEmpty() && dir[i] == left && dir[t.peek()] == right) {
                // 当前鱼 小于 栈中的鱼，就被吃了
                if (size[i] < size[t.peek()]) {
                    hasEat = true;
                    break;
                }
                // 当前鱼 大于 栈中的鱼，栈中的鱼被吃
                t.pop();
            }
            // 不满足的情况下
            if (!hasEat) {
                t.push(i);
            }
        }
        return t.size();
    }
}
