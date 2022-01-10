package leetcode.top100;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 双向指针？ 上下指针？ 滑动窗口？
 *
 */
public class Q3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("qabcazdf"));
        System.out.println(lengthOfLongestSubstring("abcabcab"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("cdd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int up = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = up; j < i; j++) {
                if (chars[i] == chars[j]) {
                    maxLength = Math.max(maxLength, i - up);
                    up = j + 1;
                    break;
                }
            }
        }
        return Math.max(maxLength, chars.length - up);
    }
}
