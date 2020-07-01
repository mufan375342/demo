package 穆帆.排序;


/**
 * @author mufan
 * @date 2020/7/1
 */
@SuppressWarnings("all")
public class ReversePairs {
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int j = mid + 1;
        int t = mid + 1;
        int k = 0;
        int[] cache = new int[right - left + 1];
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            //这里为什么是mid+1.是因为如果上面的条件成立，while条件j++会多加一个1
            res += j - (mid + 1);

            //这里进行排序，变量nums[t]与nums[i]只有关系
            while (t <= right && nums[i] > nums[t]) {
                cache[k++] = nums[t++];
            }
            //将变量nums[i]归并到cache
            cache[k++] = nums[i];
        }
        while (t <= right) {
            cache[k++] = nums[t++];
        }
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return res;
    }
}
