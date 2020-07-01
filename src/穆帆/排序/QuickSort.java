package 穆帆.排序;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/7/1
 */
@SuppressWarnings("all")
public class QuickSort {
    /**
     * 快速排序
     *
     * @param nums
     * @param begin
     * @param end
     */
    public static void quickSort(int[] nums, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = parttition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private static int parttition(int[] nums, int begin, int end) {
        int pivot = end;
        int count = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[count];
        nums[count] = temp;
        return count;
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (right + left) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 9, 6, 43};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1, 4, 2, 3, 9, 6, 43};
        mergeSort(nums1, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, 4, 2, 3, 9, 6, 43};
        System.out.println(Arrays.toString(nums2));
    }
}
