package 穆帆.排序;

/**
 * @author mufan
 * @date 2020/7/1
 */
@SuppressWarnings("all")
public class 逆序对 {
    public static int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int[] cache = new int[right - left + 1];
        int k = 0;

        int j = mid + 1;
        int t = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > nums[j]) {
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

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 1};
        int i = reversePairs(nums);
        System.out.println(i);
    }
}
