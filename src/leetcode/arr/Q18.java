package leetcode.arr;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 *
 */
public class Q18 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        System.out.println(fourSum(nums, 0));
    }

    // 入户阳台
    // 橱柜   米板柜子  洗碗柜  出水口  电源
    // 封窗  材质  断桥铝   500？ 纱窗150
    // 刷墙
    // 洗手台 阳台  洗衣机
    // 窗帘 ？
    // 改电
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> rtn = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                    if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                        r--;
                        continue;
                    }
                    if (nums[i] + nums[j] - target < -(nums[l] + nums[r])) {
                        l++;
                    } else if (nums[i] + nums[j] - target > -(nums[l] + nums[r])) {
                        r--;
                    }else{
                        rtn.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                    }
                }
            }
        }
        return rtn;
    }

}
