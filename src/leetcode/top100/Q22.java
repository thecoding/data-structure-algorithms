package leetcode.top100;


import java.util.ArrayList;
import java.util.List;

public class Q22 {


    public static void main(String[] args) {
        List<String> strings = generateParenthesis(2);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        dfs("", 0, 0, list, n);
        return list;
    }

    private static void dfs(String path, int left, int right, List<String> list, int n) {
        if (left > n || right > left) {
            return;
        }
        if (path.length() == 2 * n) {
            list.add(path);
            return;
        }
        dfs(path + "(", left + 1, right, list, n);
        dfs(path + ")", left, right + 1, list, n);
    }
}
