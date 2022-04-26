package leetcode.top100;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * 输入：s = "()(())"
 * 输出：4
 * 解释：最长有效括号字串是 "(())"
 *
 * 有效子串：要么是平级的，要么是复合的  x
 */
public class Q32 {


    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses2(s));
    }


    // 怎么确定是子串 ？ 为什么是两次遍历呢？
    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }



    // 动态规划
//    动态规划问题，大致可以通过以下四步进行解决。
//    1. 划分状态，即划分子问题，例如上面的例子，我们可以认为每个组下面、每个部门、每个中心下面最优秀的3个人，都是全公司最优秀的3个人的子问题。
//    2. 状态表示，即如何让计算机理解子问题。上述例子，我们可以用f[i][3]表示第i个人，他手下最优秀的3个人是谁。
//    3. 状态转移，即父问题是如何由子问题推导出来的。上述例子，每个大Leader下面最优秀的人等于他下面的小Leader中最优秀的人中最优秀的几个。
//    4. 确定边界，确定初始状态是什么？最小的子问题？最终状态又是什么。例如上述问题，最小的子问题就是每个小组长下面最优秀的人，最终状态是整个企业，初始状态为每个领导下面都没有最优名单，但是小组长下面拥有每个人的评分。
    public static int longestValidParentheses(String s) {
        int max = 0;
        return max;
    }
}
