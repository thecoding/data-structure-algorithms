package leetcode.top100;

public class Q33 {

    public static void main(String[] args) {
        int target = 0;
        int[] nums = {5,1,3};
        System.out.println(search2(nums, target));
    }

    // 暴力解
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 二分查找
    public static int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length -1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[lo]) {
                // 左边是升序，右边降序
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

}
