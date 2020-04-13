package 练习;

/**
 * @author mufan
 * @date 2020/4/12
 */
public class Num_33_搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //存在两种情况,前半部分是升序或者后半部分是升序
            if (nums[mid] >= nums[left]) {
                //假设target在前半部分
                if (target >= nums[left] && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
