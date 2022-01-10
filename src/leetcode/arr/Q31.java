package leetcode.arr;


import java.util.Arrays;

/**
 * 1. 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
 * 2. 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
 * 3. 将 A[i] 与 A[k] 交换
 * 4. 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
 * 5. 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
 *
 * 作者：imageslr
 * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q31 {


    public static void main(String[] args) {
        int[] n = {3,2,5,3,2};
//        int[] n = {1,2};
        nextPermutation(n);
        for (int i : n) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 从后查找一个 升序的节点
        for (int i = nums.length - 1; i >= 1; i--) {
            // 第一个升序的
            if (nums[i] > nums[i - 1]) {
                // 从后往前，到i节点，如果有大于 n - 1 就交换
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, j, i - 1);
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
        int n = (j - i) / 2;
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
