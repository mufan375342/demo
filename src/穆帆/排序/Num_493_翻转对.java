package 穆帆.排序;

/**
 * @author mufan
 * @date 2020/7/5
 */
public class Num_493_翻转对 {

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int[] cache = new int[right - left + 1];
        int k = 0;

        int j = mid + 1;
        int t = mid + 1;
        for (int i = 0; i <= mid; i++) {
            while (j <= right && nums[i] / 2 > nums[j]) {
                j++;
            }
            res += j - mid - 1;

            while (t <= right && nums[i] > nums[t]) {
                cache[k++] = nums[t++];
            }
            cache[k++] = nums[i];
        }

        while (t <= right) {
            cache[k++] = nums[t++];
        }
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return res;
    }
}
