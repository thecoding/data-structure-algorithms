package leetcode.arr;


/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 传入数组引用，需要修改原数组的值，并且返回数组大小
 * 题解： 双向指针，如果 nums[fast] = nums[slow] fast++ else nums[++slow] = nums[fast]
 */
public class Q26 {

    public static void main(String[] args) {
        int[] n = {1,1,2};
//        int[] n = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(n));
        for (int i : n) {
            System.out.print(i + ",");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
