package lagou.module1;

import java.util.Stack;

/**
 * 【题目】一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
 *  输入：[5, 2]
 *  输出：[1, -1]
 *  解释：因为元素 5 的右边离我最近且比我小的位置应该是 A[1]，最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
 */
public class Eg3 {

    public static void main(String[] args) {
        int[] a = {5, 2, 3, 1};
        for (int i : findRightSmall(a)) {
            System.out.println(i);
        }
    }

    public static int[] findRightSmall(int[] arr) {
        if (arr.length <= 0) {
            return new int[0];
        }
        int[] tmp = new int[arr.length];
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 当前值比栈中的值小
            while (!t.isEmpty() && arr[i] < arr[t.peek()]) {
                tmp[t.peek()] = i;
                t.pop();
            }
            // 当前值比栈中的值大
            t.push(i);
        }
        while (!t.isEmpty()) {
            tmp[t.peek()] = -1;
            t.pop();
        }
        return tmp;
    }
}
