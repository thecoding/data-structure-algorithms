package leetcode;

/**
 * leetcode11
 */
public class Q11 {


    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(arr));
//        System.out.println(1 << 1);
    }


    public static int maxArea2(int[] height) {
        int max = 0;
        for (int i=0,j = height.length - 1; i < j;){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, minHeight * (j - i + 1));
        }
        return max;
    }

    /**
     * 超出时间限制
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i=0; i< height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int weight = j - i;
                if (height[i] >= height[j]) {
                    max = Math.max((height[j] * weight), max);
                } else {
                    max = Math.max((height[i] * weight), max);
                }
            }
        }
        return max;
    }


}
