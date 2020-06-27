package 练习;

/**
 * @author mufan
 * @date 2020/5/5
 */
public class Num_5_最长回文子串 {
    /**
     * 暴力求解
     */
    public String longestPalindrome(String s) {
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

    private boolean valid(String s, int left, int right) {
        // 验证子串 s[left, right] 是否为回文串
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 动态规划
     */
    public static String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int record = 1;
        String res = s.substring(0, 1);
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        //j从前往后填写
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > record) {
                        record = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 中心扩散
     */
    private int lo;
    private int maxLen;

    public String longestPalindrome3(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            //odd
            centerSpread(s, i, i);
            //even
            centerSpread(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void centerSpread(String s, int j, int k) {
        int length = s.length();
        while (j >= 0 && k < length && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (k - j - 1 > maxLen) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
