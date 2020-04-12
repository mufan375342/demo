package 练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mufan
 * @date 2020/4/12
 */
public class 四个数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp > target) {
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public int jump(int[] nums) {
        int end = 0;
        int position = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            position = Math.max(nums[i] + i, position);
            if (end == i) {
                end = position;
                step++;
            }
        }
        return step;
    }
}
