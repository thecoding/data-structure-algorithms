package lagou.module1;

import java.util.Stack;

/**
 * 字典序最小的 k 个数的子序列
 * 【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 *
 * 解释：在所有可能的解：{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 字典序最小。
 *
 * 所谓字典序就是，给定两个数组：x = [x1,x2,x3,x4]，y = [y1,y2,y3,y4]，如果 0 ≤ p < i，xp == yp 且 xi < yi，那么我们认为 x 的字典序小于 y。
 *
 * 字典序最小：通俗的理解为 按顺序拍好后，数值是最小的。 比如k为2，表示两位数，任取两个 35 26 ，此时35 > 26 因此字典序小的为 26，
 * 注意，不能改变字典中的顺序
 */
public class Eg4 {

    public static void main(String[] args) {
        int[] a = {9, 2, 0, 5, 1, 2, 3, 0};
        for (int i : findSmallSeq(a, 3)) {
            System.out.println(i);
        }
    }


    public static int[] findSmallSeq(int[] arr, int k) {
        int[] tmp = new int[k];
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("当前能弹出 %d 个\n", arr.length - i  - k);
            while (!t.isEmpty() && t.size() <= k && arr[i] < arr[t.peek()] && arr.length - i  - k >= 0) {
                t.pop();
            }
            if (t.size() < k) {
                t.push(i);
            }
        }
        while(!t.isEmpty()){
            tmp[--k] = arr[t.peek()];
            t.pop();
        }
        return tmp;
    }
}
