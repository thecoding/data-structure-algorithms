package leetcode.arr;

public class Q4 {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums1.length > 0 ? nums1[0] : nums2[0];
        }
        // 不管是奇数还是偶数，都取 length/2 + 1
        // 奇数，刚好就是中位数，偶数，刚好就是最后两个数 2
        int middle = length / 2 + 1;
        int n1 = 0;
        int n2 = 0;
        int min = 0, max = 0;
        // 最主要是从两个数组中取数的边界问题
        for(int i=0; i<middle; i++){
            // 依次从两个nums取一个相对小的数
            int left = n1 < nums1.length ? nums1[n1] : -1;
            int right = n2 < nums2.length ? nums2[n2] : -1;
            min = max;
            if (n1 < nums1.length && n2 < nums2.length) {
                max = Math.min(left, right);
                if (left >= right) {
                    n2++;
                }else{
                    n1++;
                }
            }else{
                // left已经超出边界，right需要往后移
                if (n1 >= nums1.length && n2 < nums2.length) {
                    max = right;
                    n2++;
                }
                // right超出边界，left需要往后移
                if (n2 >= nums2.length && n1 < nums1.length) {
                    max = left;
                    n1++;
                }
            }
        }
        if ((length & 1) == 1) {
            return max;
        }else{
            return (min + max) / 2.0;
        }
    }
}
