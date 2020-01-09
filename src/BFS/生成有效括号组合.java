package BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mufan
 * @date 2020/1/9
 */
public class 生成有效括号组合 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, result);
        dfs1("", 0, 0, result);
        return result;
    }

    private static void dfs(String subStr, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(subStr);
            return;
        }
        //先要填充左括号
        if (left > 0) {
            dfs(subStr + "(", left - 1, right, result);
        }
        if (right > left) {
            dfs(subStr + ")", left, right - 1, result);
        }
    }

    private static void dfs1(String subStr, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(subStr);
            return;
        }
        //先要填充左括号
        if (left > 0) {
            dfs(subStr + "(", left + 1, right, result);
        }
        if (right > left) {
            dfs(subStr + ")", left, right + 1, result);
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        list.forEach(item -> System.out.println(item));
    }
}
