package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/6/26
 */
public class Num_493_翻转对 {

    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            res += j - (mid + 1);
        }
        //时间复杂度是nlog(n),整个方法的时间复杂度是log(n)*nlog(n),这里需要注意是指定长度排序
        Arrays.sort(nums, left, right + 1);
        return res;
    }

    public static int reversePairs1(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return mergeSort1(nums, 0, nums.length - 1);
    }

    private static int mergeSort1(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int res = mergeSort1(nums, left, mid) + mergeSort1(nums, mid + 1, right);
        int[] cache = new int[right - left + 1];
        int c = 0;
        int t = mid + 1;
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            res += j - (mid + 1);

            while (t <= right && nums[i] > nums[t]) {
                cache[c++] = nums[t++];
            }
            cache[c++] = nums[i];
        }
        while (t <= right) {
            cache[c++] = nums[t++];
        }
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1};
        reversePairs1(arr);
    }

}
