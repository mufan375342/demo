package 哈希;

import java.util.*;

/**
 * @author mufan
 * @date 2019/12/25
 */
public class 三个数之和 {
    /**
     * 枚举nums的每一个值然后使用两个指针往中间夹的方式去判断
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp > 0) {
                    right -= 1;
                } else if (temp < 0) {
                    left += 1;
                } else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    res.add(integers);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
