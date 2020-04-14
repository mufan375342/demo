package 练习;

/**
 * @author mufan
 * @date 2020/4/14
 */
public class 找出半有序数组无序的地方 {
    /**
     * 相当于是找出最小值的下标
     */
    public static int search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //左半边是有序的.无序的地方肯定在右半边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int search = search(arr);
        System.out.println(search);
    }
}
