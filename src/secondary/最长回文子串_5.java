package secondary;

/**
 * @author mufan
 * @time 2019/8/10
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * TODO Manacher算法有待学习
 */
public class 最长回文子串_5 {
    /**
     * dp状态
     * dp[i][j]指的是字符串s中最长回文子串
     * i表示的是其实索引值,j表示的是终止索引值
     * dp方程
     * dp[i][j]=dp[i-1][j+1]+1
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length();
        char[] str = s.toCharArray();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (str[i] == str[j] && ((j - i <= 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
