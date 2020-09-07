package 每日一题.字符串;

/**
 * @author mufan
 * @date 2020/8/28
 */
@SuppressWarnings("all")
public class 正则表达式匹配 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = match(s, p, i, j) && dp[i - 1][j - 1];
                } else {
                    //这里会有 s = ab 和 s = abb* 的问题
                    dp[i][j] = match(s, p, i, j - 1) ? dp[i - 1][j] || dp[i][j - 2] : dp[i][j - 2];

                }
            }
        }
        return dp[m][n];
    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
