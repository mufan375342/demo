package 每日一题.字符串;

/**
 * @author mufan
 * @date 2020/8/28
 */
public class 不同的子序列 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                //如果两个字符相等的情况下有两种情况
                //例如 abcc & abc 计算的时候需要将第一个字符串的c打掉后看他包含多少个abc,或者是同时将两个字符串的最后一个c都打掉看包含多少个ab
                //1.当考虑使用第i个元素时，即我们让 abcc 中的最后一个c 和abc最后一个c匹配上，这时我们需要看的是 abc中含有多少个 ab ,对应dp[i-1][j-1]
                //2.当不考虑使用第i个元素时，我们需要看的是 abc 中含有多少个abc ,对应dp[i][j-1]
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
