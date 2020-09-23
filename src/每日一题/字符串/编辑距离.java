package 每日一题.字符串;

/**
 * @author mufan
 * @date 2020/8/26
 */
public class 编辑距离 {
    /**
     * 状态的定义
     * dp[i][j] 表示 word1 前i个字符 和 word2 前j个字符
     * 如果 word1[i] == word2[j] 相同的情况下   edit_dist(i,j) = edit_dist(i-1,j-1)
     * 如果 word1[i] == word2[j] 不相同的情况下  edit_dist(i,j) = MIN( edit_dist(i-1,j-1)+1 , edit_dist(i,j-1)+1 , edit_dist(i-1,j)+1 )
     */

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        //这里需要注意的是遍历的时候是从第1个字符开始比较,这时候第一个字符的下标为0,所以上面说的word1[i] == word2[j] 实际在用的过程中是word1.charAt(i - 1) == word2.charAt(j - 1)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


}
