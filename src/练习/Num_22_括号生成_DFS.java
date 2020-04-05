package 练习;

/**
 * @author mufan
 * @date 2020/4/4
 */

import java.util.ArrayList;
import java.util.List;

public class Num_22_括号生成_DFS {

    // 把结果集保存在动态规划的数组里

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String currStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(currStr);
            return;
        }
        if (left > 0) {
            dfs(currStr + "(", left - 1, right, res);
        }
        if (left < right) {
            dfs(currStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(4);
        System.out.println(1234567);
    }
}
