package 练习;

/**
 * @author mufan
 * @date 2020/6/22
 */
@SuppressWarnings("all")
public class 排序 {
    /**
     * 快速排序
     */
    public static void quickSort(int[] nums, int begin, int end) {
        if (end <= begin) {
            return;
        }
        //parttition 分批;pivot 中心,枢纽
        int pivot = parttition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private static int parttition(int[] nums, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[counter];
                nums[counter] = nums[i];
                nums[i] = temp;
                counter++;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[counter];
        nums[counter] = temp;
        return counter;
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
            nums[p + left] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 9, 6, 43};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println("----------");

        mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
