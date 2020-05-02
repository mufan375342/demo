package 练习;

/**
 * @author mufan
 * @date 2020/5/2
 */
public class Num_518_零钱兑换2 {
    /**
     * 思路：
     * 1.假设零钱有2分，5分，10分
     * 2.需要组成11块钱，求有多少种组法
     * 3.直视这个题，就是一个二维的数组，横坐标是1到11，纵坐标是2，5，10
     * 因为硬币的个数是无限的，所以动态规划的方程为
     * dp[i][j] =
     * <p>
     * dp[i-1][j - 0 * coins[i]]]
     * dp[i-1][j - 1 * coins[i]]]
     * dp[i-1][j - 2 * coins[i]]]
     * dp[i-1][j - k * coins[i]]]
     * <p>
     * 以上的动态方程 j-K*coins[i] 必须大于0
     * 4.这个时候就可以求解
     */
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int[][] dp = new int[len][amount + 1];
        //如果amount==0的情况下，返回1，是一种特殊的情况
        dp[0][0] = 1;
        //填充第行数据
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; j - k * coins[i] >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }

    /**
     * 优化1:
     * dp方程1：
     * dp[i][j] =
     * <p>
     * dp[i-1][j - 0 * coins[i]]]
     * dp[i-1][j - 1 * coins[i]]]
     * dp[i-1][j - 2 * coins[i]]]
     * dp[i-1][j - k * coins[i]]]
     * <p>
     * <p>
     * dp方程2：
     * dp[i][j-coins[i]] =
     * <p>
     * dp[i-1][j - 1 * coins[i]]]
     * dp[i-1][j - 2 * coins[i]]]
     * dp[i-1][j - 3 * coins[i]]]
     * dp[i-1][j - k * coins[i]]]
     * <p>
     * <p>
     * 方程1-方程2得到
     * dp[i][j] - dp[i][j-coins[i]] = dp[i-1][j]
     * 得到最终的方程
     * dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
     */
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int[][] dp = new int[len][amount + 1];
        //如果amount==0的情况下，返回1，是一种特殊的情况
        dp[0][0] = 1;
        //填充第行数据
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }

    /**
     * 优化3:
     * dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
     */
    public int change3(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int[] dp = new int[amount + 1];
        //如果amount==0的情况下，返回1，是一种特殊的情况
        dp[0] = 1;
        //填充第行数据
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            // 从 coins[i] 开始即可
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
