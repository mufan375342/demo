package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/5/3
 */
public class Num_213_打家劫舍II {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
        System.arraycopy(nums, 1, nums2, 0, nums.length - 1);

        //分别求两个数组的组大值
        return Math.max(getMax(nums1), getMax(nums2));

    }

    public static int getMax(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        System.out.println(rob(arr));
    }
}
