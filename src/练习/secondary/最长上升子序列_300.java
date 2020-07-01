package 练习.secondary;

/**
 * @author mufan
 * @time 2019/8/10
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4
 */
public class 最长上升子序列_300 {
    /**
     * dp
     * 定义状态:dp[i]数组中最长子序列长度,i指的是数组中的每一个元素
     * 题目分析:首先枚举每一个数看他前面的数的最长子序列,因为每一个数都需要进行枚举,所以需要用一个int res=0来标记最大的长度
     * 比如:枚举到7的时候.最长的序列数为2，3，7或者3，5，7
     * dp方程
     * dp[i]=dp[j]+1;j指的是i前面一个的上升子序列的长度比如9，前面最长子序列的长度在满足nums[j]<nums[i]的情况下最大长度为0
     * 条件:nums[j]<nums[i]
     *
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //初始化dp
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //因为dp初始化为1,所以每次都需要更新dp的值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //每循环一次获取最大值
            res = Math.max(dp[i], res);
        }
        return res;
    }




    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }
}
