package leetcode.arr;


import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 */
public class Q28 {

    public static void main(String[] args) {
        int[] n = {1};
//        int[] n = {0,0,1,1,1,2,2,3,3,4};
        System.out.println();

        int[] n1 = {1,2};
        nextPermutation(n1);
        for (int i : n1) {
            System.out.print(i + ",");
        }
        System.out.println();

        int[] n2 = {1, 3, 2};
        nextPermutation(n2);
        for (int i : n2) {
            System.out.print(i + ",");
        }
        System.out.println();
    }


    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 从后往前找到第一个升序的节点
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i-1]){
                // 从i节点开始查找一个比i-1大的数字
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                reversal(nums, i, nums.length - 1);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private static void reversal(int[] nums, int i, int j) {
        if (i < j) {
            return;
        }
        int n = (j - i)/2;
        for (int s = 0; s <= n; s++) {
            swap(nums, i + s, j - s);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
