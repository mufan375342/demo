package 每日一题;

/**
 * @author mufan
 * @date 2020/7/6
 */
public class Num_63_不同路径II {
    /**
     * dp[i][j] = dp[i-1][j] + dp[i][j-1] dp[i][j]表示从坐标 (0, 0) 到坐标 (i, j) 的路径总数
     * 如果碰到了障碍物，则dp[i][j] = 0 即通过任何一条路径都不能到达该点，因为该点是个障碍物，机器人就不可能达到该点（点被障碍物所占据）即他不能给其他的点贡献路径数
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[0][i] == 1) {//遇到障碍物了
                break;
            }
            obstacleGrid[0][i] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[i][0] == 1) {//遇到障碍物了
                break;
            }
            obstacleGrid[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
