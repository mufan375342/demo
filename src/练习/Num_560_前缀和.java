package 练习;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/5/28
 * https://zhuanlan.zhihu.com/p/107778275
 */
public class Num_560_前缀和 {
    /**
     * 暴力求解
     * 枚举所有的子串
     * 暴力解法的时间复杂度为O(N^3)
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                //求所有子串的和,如果符合sum==k,则res+1
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * 暴力求解优化
     * 枚举所有的子串(固定左边界,然后枚举右边界)时间复杂度降低
     * 暴力解法的时间复杂度为O(N^2)
     */
    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k) {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * 前缀和
     */
    public int subarraySum2(int[] nums, int k) {

        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                //这里同样是固定左边界.然后根据前缀和数组进行计算,注意指针的偏移,因为前缀和的第一位是一个无效位.所以right必须+1
                if (preSum[right + 1] - preSum[left] == k) {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * hash+前缀和
     */
    public int subarraySum3(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        /*
         * 初始化这一步可以这么理解,对于一开始的情况,下标0之前没有元素,可以认为前缀和为0,个数为1
         * 实际上这里是为了处理特殊的情况，如果nums = [5，4，3], k = 5那 i=0,preSum=5, preSum - k = 0, preSumFreq.containsKey(preSum - k)存在,count =1
         * 前缀和的问题初始化的时候都可以这样初始化,可以作为模板代码。只要用到前缀和基本上都需要考虑初始化（0,1）
         */
        map.put(0, 1);
        for (int item : nums) {
            sum += item;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        Num_560_前缀和 test = new Num_560_前缀和();
        int res = test.subarraySum(nums, k);
        int res1 = test.subarraySum1(nums, k);
        System.out.println(res);
        System.out.println(res1);
    }
}
