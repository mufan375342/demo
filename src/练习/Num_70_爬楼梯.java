package 练习;

/**
 * @author mufan
 * @date 2020/5/1
 */
public class Num_70_爬楼梯 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return test(0, n, memo);
    }

    private int test(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        return test(i + 1, n, memo) + test(i + 2, n, memo);
    }
}
