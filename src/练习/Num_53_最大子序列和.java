package 练习;

/**
 * @author mufan
 * @date 2020/5/2
 */
public class Num_53_最大子序列和 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
        }
        for (int value : dp) {
            res = Math.max(res, value);
        }
        return res;
    }

    public int maxSubArray3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(0, dp) + nums[i];
            res = Math.max(res, dp);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            int sum = nums[i];
            for (int j = i; j < nums.length; j++) {

                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

}
