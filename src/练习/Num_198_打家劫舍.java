package 练习;

/**
 * @author mufan
 * @date 2020/5/3
 */
public class Num_198_打家劫舍 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //0是偷,1是不偷
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            //如果第i天不偷，则第i-1天可以不偷也可以偷
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //如果第i天偷，则第i-1天必然是不偷
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 简化为一维数组
     * 假设第i天偷,则第i减一天不偷,i-2天必须偷
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
