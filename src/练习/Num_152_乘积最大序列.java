package 练习;

/**
 * @author mufan
 * @date 2020/5/2
 */
public class Num_152_乘积最大序列 {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxDp = 1;
        int minDp = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = maxDp;
                maxDp = minDp;
                minDp = temp;
            }
            maxDp = Math.max(num, num * maxDp);
            minDp = Math.min(num, num * minDp);
            res = Math.max(res, maxDp);
        }
        return res;
    }

    public static int maxProducta(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxdp[i - 1];
                maxdp[i - 1] = mindp[i - 1];
                mindp[i - 1] = temp;
            }
            maxdp[i] = Math.max(maxdp[i - 1] * nums[i], nums[i]);
            mindp[i] = Math.min(mindp[i - 1] * nums[i], nums[i]);
            res = Math.max(res, maxdp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums={-2};
        maxProducta(nums);
    }
}
