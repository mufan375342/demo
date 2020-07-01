package 练习.哈希;

import java.util.*;

/**
 * @author mufan
 * @date 2019/12/25
 */
public class 两个数之和 {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (map.containsKey(i1)) {
                res[0] = map.get(i1);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        twoSum(nums, 9);
    }
}
