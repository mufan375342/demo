package 练习.secondary;

import java.util.Arrays;
import java.util.List;

/**
 * @author mufan
 * @time 2019/8/13
 * 求三角形最小路径
 */
public class 三角形最小路径_120 {
    /**
     * 解法1:暴力,dfs解决,时间复杂度是指数级别的
     */
    private int minSum = Integer.MAX_VALUE;

    private int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        dfs(triangle, 0, 0, 0);
        return minSum;

    }

    private void dfs(List<List<Integer>> triangle, int i, int j, int sum) {
        //termintor (递归终止条件)
        if (i == triangle.size() - 1) {//i == triangle.size()说明已经走到头了
            sum += triangle.get(i).get(j);
            if (sum < minSum) {
                minSum = Math.min(sum, minSum);
            }
            return;
        }
        //process (每下一层需要的处理逻辑)
        sum += triangle.get(i).get(j);
        //drill down (递归)向下走
        dfs(triangle, i + 1, j, sum);
        //向右下走
        dfs(triangle, i + 1, j + 1, sum);
        //clear status (状态还原),因为这里只改变了path,所以这里不需要进行clear

    }

    /**
     * 解法2:dp(该dp污染了元数据)
     * 状态定义:dp[i][j]
     * dp方程:dp[i][j]=Math.min(dp[i][j]+dp[i+1][j],dp[i][j]+dp[i+1][j+1])
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int temp = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, temp);
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     * 解法3:dp(使用临时变量记录不污染元数据)
     * 状态定义:dp[i][j]
     * dp方程:dp[i][j]=Math.min(dp[i][j]+dp[i+1][j],dp[i][j]+dp[i+1][j+1])
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int[] temp = new int[triangle.size()];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                temp[j] = triangle.get(i).get(j) + Math.min(temp[j], temp[j + 1]);
            }
        }
        //因为头元素只有一个,所以最终的元素就是temp[0]
        return temp[0];
    }
    public static void main(String[] args) {
        三角形最小路径_120 sol = new 三角形最小路径_120();
        int result = sol.minimumTotal1(Arrays.asList(
                Arrays.asList(    2 ),
                Arrays.asList(  3, 4),
                Arrays.asList( 6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        ));
        System.out.println(result);
    }
}
