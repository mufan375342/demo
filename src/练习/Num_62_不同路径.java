package 练习;

/**
 * @author mufan
 * @date 2020/5/1
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class Num_62_不同路径 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 将二维数组优化为一位数组的解法
     * 之所以能用一维数组是因为以为我们最终要求的数实际上是保存在最后一行
     * 一维数组可以表示的每一个元素则表示的就是行和列上的值
     */
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //这里需要注意用dp[j]还是dp[i]
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[m - 1];
    }
}
