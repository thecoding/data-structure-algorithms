package leetcode.top100;

public class Q34 {

    public static void main(String[] args) {
        int target = 9;
        int[] nums = {1,9,9};
//        System.out.println(search2(nums, target));

        int[] ints = searchRange(nums, target);
        System.out.println("[" + ints[0] + "," + ints[1] + "]");
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] rtnInt = new int[2];
        int targetIndex = search(nums, target);
        if (targetIndex == -1) {
            rtnInt[0] = -1;
            rtnInt[1] = -1;
            return rtnInt;
        }
        int leftIndex = leftIndex(nums, target, targetIndex);
        int rightIndex = rightIndex(nums, target, targetIndex);
        leftIndex = Math.min(leftIndex, targetIndex);
        rightIndex = Math.max(targetIndex, rightIndex);
        rtnInt[0] = leftIndex;
        rtnInt[1] = rightIndex;
        return rtnInt;
    }


    public static int rightIndex(int[] nums, int target, int targetIndex) {
        for (int i = targetIndex + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                return i - 1;
            }
            if (i == nums.length - 1) {
                return i;
            }
        }
        return targetIndex;
    }

    public static int leftIndex(int[] nums, int target, int targetIndex) {
        for (int i = targetIndex - 1; i >= 0; i--) {
            if (nums[i] != target) {
                return i + 1;
            }
            if (i == 0) {
                return i;
            }
        }
        return targetIndex;
    }

    public static int search(int[] nums, int target) {
        int lo = 0,hi = nums.length -1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        return -1;
    }



}
