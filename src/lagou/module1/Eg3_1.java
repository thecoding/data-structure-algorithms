package lagou.module1;

import java.util.Stack;

// 找到右边第一个比当前数大的数
public class Eg3_1 {

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 9, 4, 0, 5 };
        for (int i : findRightLarge(a)) {
            System.out.println(i);
        }
    }

    public static int[] findRightLarge(int[] arr){
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] tmp = new int[arr.length];
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!t.isEmpty() && arr[i] > arr[t.peek()]) {
                tmp[t.peek()] = i;
                t.pop();
            }
            // 当前比栈中小
            t.push(i);
        }
        while (!t.isEmpty()) {
            tmp[t.peek()] = -1;
            t.pop();
        }
        return tmp;
    }
}
