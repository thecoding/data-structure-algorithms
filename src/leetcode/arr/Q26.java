package leetcode.arr;


/**
 * 传入数组引用，需要修改原数组的值，并且返回数组大小
 */
public class Q26 {

    public static void main(String[] args) {
        int[] n = {1,1,2};
//        int[] n = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(n));
    }

    // todo
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int t = 1;
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp[t - 1] != nums[i]) {
                tmp[t++] = nums[i];
            }
        }
        int a = 0;
        int b = t;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp[a]) {
                tmp[b++] = nums[i];
            }else{
                a++;
            }
        }
        nums = tmp;
        return t;
    }
}
