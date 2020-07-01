package 练习.secondary;

import java.util.Arrays;

/**
 * @author mufan
 * @time 2019/8/9
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class 零钱兑换_322 {
    /**
     * dp
     * 状态定义
     * dp[i] 代表组合成金额为i的硬币的最小个数
     * dp方程
     * dp[i]=dp[i-coins[j]]+1
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    static int minCount = Integer.MAX_VALUE;

    /**
     * dfs
     */
    private static int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        recursion(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    /**
     * 1、按金额从大到小，从多到少（排序，用余数一步到位）
     * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
     * 3、能整除即可返回
     * coins = [3, 2, 5], amount = 11
     * 如果是3最多有3个,如果是2最多有5个,如果是5最多是2个
     * 排序的原因是提高效率
     * 可以吧问题想想为
     *    5 5
     *   3 3 3
     * 2 2 2 2 2 2
     * 然后dfs进入每一层进行判断
     */
    private static void recursion(int[] coins, int amount, int count, int index) {
        //没到一层的时候需要判断count + (amount/coins[index]) 所需要的硬币总数大于minCount相当于剪枝
        if (index < 0 || count + (amount / coins[index]) >= minCount) {
            return;
        }
        //如果是恰好等于amount则取最小值
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        //dfs
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2};
        System.out.println(coinChange1(arr, 3));

    }
}
