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

    /**
     * 快速排序
     */
    public static int[] test(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return nums;
        }
        int left = start;
        int right = end;
        int temp = nums[start];
        while (left < right) {
            //右边的指针进行移动,大于等于的在右边,小于的在左边
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            //左边的指针开始移动(注意这里可以是小于也可以是小于等于)
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        if (left == right) {
            nums[left] = temp;
        }
        if (left != start) {
            test(nums, 0, left - 1);
        }
        if (right != end) {
            test(nums, right + 1, nums.length-1);
        }
        return nums;
    }



    public static void main(String[] args) {
        int[] nums = {6,2,6,1,6,6};
        int[] test = test(nums, 0, nums.length - 1);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        System.out.println("---------------------");
        Arrays.sort(nums);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
