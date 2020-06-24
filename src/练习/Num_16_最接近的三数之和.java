package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/6/24
 */
public class Num_16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - temp) < Math.abs(target - res)) {
                    res = temp;
                }
                //大于让res小点看能不能靠近target
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
