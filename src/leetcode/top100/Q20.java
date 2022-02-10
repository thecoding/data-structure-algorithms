package leetcode.top100;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q20 {

    public static void main(String[] args) {
//        String s = "([{{{}}}]";
        String s = "(]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        char[] c = s.toCharArray();
        // 构造一个数组，作为栈来使用
        int[] stack = new int[c.length];
        char[] leftChar = {'(','{','['};
        char[] rightChar = {')','}',']'};

        int index = -1;
        for (char c1 : c) {
            boolean isMatch = false;
            // 前部分匹配
            for (int i = 0; i < leftChar.length; i++) {
                if (c1 == leftChar[i]) {
                    isMatch = true;
                    stack[++index] = i;
                    break;
                }
            }
            if (!isMatch) {
                // 后部分匹配
                for (int i = 0; i < rightChar.length; i++) {
                    if (c1 == rightChar[i]) {
                        if(index < 0) return false;
                        // 后部分跟前部分的位置是否匹配，如果匹配，stack当前设置为空，并且indexLeft往后移
                        if (i == stack[index]) {
                            stack[index--] = -1;
                        }else{
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        return index == -1 ? true : false;
    }
}
