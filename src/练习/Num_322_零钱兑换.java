package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/5/2
 */
public class Num_322_零钱兑换 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {2, 5, 10, 1};
        System.out.println(coinChange(coins, 27));
    }

}
