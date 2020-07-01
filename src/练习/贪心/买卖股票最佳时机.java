package 练习.贪心;

/**
 * @author mufan
 * @date 2020/1/6
 * 贪心算法与动态规划对比，贪心算法每次都是选择最优的解,但是操作的状态是不可以回退的
 * 买卖股票使用贪心的算法，每次都对比后一天的股票与前一天进行比较，如果前一天比后一天小，则前一天买入，后一天卖出
 */
public class 买卖股票最佳时机 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) {
            return maxProfit;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
