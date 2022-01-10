package leetcode.top100;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 回文 -> abba  cc  aba
 * 而且是最长的回文  abba -> bb abba 最长就是 4
 * 先找到第一个char，然后往后去匹配一个相同的char，匹配到了就判断中间是否对称（二分法匹配）
 *  如果是对称就是回文，解析长度
 *  如果不对称，就找下一个回文
 * 上下指针？ 滑动窗口？
 */
public class Q5 {

    public static void main(String[] args) {
        System.out.println("qabcazdf --> " +  longestPalindrome("qabcazdf"));
        System.out.println("abcabcab --> " + longestPalindrome("abcabcab"));
        System.out.println("bbbbb --> "  +  longestPalindrome("bbbbb"));
        System.out.println("cdd --> " + longestPalindrome("cdd"));
        System.out.println("babad --> " + longestPalindrome("babad"));
        System.out.println("ccc --> " + longestPalindrome("ccc"));

    }

    public static String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        String maxString = chars[0] + "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    if (((j - i + 1) > max) && splitEquals(chars, i, j)) {
                        max = j - i + 1;
                        maxString = s.substring(i, j + 1);
                    }
//                    break;
                }
            }
        }
        return maxString;
    }

    private static boolean splitEquals(char[] chars, int i, int j) {
        int num = (j - i) / 2;
        for (int s = 0; s <= num; s++) {
            if (chars[i + s] != chars[j - s]) {
                return false;
            }
        }
        return true;
    }
}
