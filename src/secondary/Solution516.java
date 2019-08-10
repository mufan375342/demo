package secondary;

/**
 * @author mufan
 * @time 2019/8/10
 * 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * 输入: "bbbab";输出:4;一个可能的最长回文子序列为 "bbbb"。
 * 输入: "cbbd";输出:2;一个可能的最长回文子序列为 "bb"。
 */
public class Solution516 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq1(s));
    }

    /**
     * dp
     * 状态定义dp[i][j]表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少
     * dp方程
     * 如果s[i]==s[j]那么 dp[i][j]=dp[i+1][j-1]
     * 如果s[i]!=s[j]那么dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
     * 最后的结果就是在dp[0][n-1]
     * 从后往前走
     * 如果要从前往后走也可以,但是一定要注意回文子序列找的时候一定要是从小到大,也就是从少往多的找
     * 要不然Math.max(dp[i + 1][j], dp[i][j - 1])不成立
     * 以下从前往后或者从后往前都有相应的代码
     * 因为本身就是求最大值,如果从大往小走根本就无法确定最大值的位置
     */
    private static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    private static int longestPalindromeSubseq1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n - 1][0];
    }

}
