package leetcode.dp;


/**
 * 给定一个由正整数组成且不存在重复数字的数组 nums，找出和为给定目标正整数 target 的组合的个数。顺序不同的序列视作不同的组合。
 */
public class Q377 {


    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }


    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;// base case
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
