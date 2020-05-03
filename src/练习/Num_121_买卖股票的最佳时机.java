package 练习;

/**
 * @author mufan
 * @date 2020/5/3
 */
public class Num_121_买卖股票的最佳时机 {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //这里注意,若果当天持有股票,要么是前一天持有股票,要么是当天买入的股票,因为当天买入前一天不可能持有股票,所以是-prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        maxProfit(arr);
    }
}
