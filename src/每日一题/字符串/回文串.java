package 每日一题.字符串;

/**
 * @author mufan
 * @date 2020/8/27
 */
public class 回文串 {
    /**
     * 动态规划
     * dp[i][j] 表示 i...j 是否是回文串
     * 如果 s[i] == s[j] 则 dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]));
     * 如果 dp[i][j] 是回文串,则更新res;
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String res = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]));
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int record = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i + 1 > record && valid(s, i, j)) {
                    record = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    int lo;
    int maxLen;

    public String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            centerSpread(s, i, i);
            centerSpread(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void centerSpread(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            lo = i + 1;
            maxLen = j - i - 1;
        }
    }

    public String longestPalindrome4(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            centerSpread1(s, i, i);
            centerSpread1(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void centerSpread1(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i + 1 > maxLen) {
            lo = i + 1;
            maxLen = j - i + 1;
        }
    }
}