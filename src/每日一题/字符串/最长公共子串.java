package 每日一题.字符串;

/**
 * @author mufan
 * @date 2020/8/26
 */
public class 最长公共子串 {

    public int longestCommonSubString(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m * n == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                res = Math.max(res, dp[m][n]);
            }
        }
        return res;
    }
}
