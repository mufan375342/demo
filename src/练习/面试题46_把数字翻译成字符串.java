package 练习;

/**
 * @author mufan
 * @date 2020/6/9
 */
public class 面试题46_把数字翻译成字符串 {

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        //这里为什么是i<=s.length,是因为s.substring截取的是前闭后开的空间
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : b;
            a = b;
            b = c;
        }
        return b;
    }

    public int translateNum1(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(translateNum(num));
    }
}
