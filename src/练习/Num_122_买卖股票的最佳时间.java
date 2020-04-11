package 练习;

/**
 * @author mufan
 * @date 2020/4/11
 */
public class Num_122_买卖股票的最佳时间 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 0) {
            return 0;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return maxProfit;
    }
}
