package 练习;

/**
 * @author mufan
 * @date 2020/4/12
 */
public class Num_33_搜索旋转排序数组 {
    /**
     * 旋转后的数组记住有以下几个特点
     * 1.旋转后的数组的mid如果大于等于start的情况下说明前面是升序排列.中位数后面可能是乱序也可能是升序
     * 为什么是大于等于而不是大于?
     * 因为在取中介点的时候取的是左中位数,所以是大于等于而不是大于
     * 2.如果中介点小于end的时候证明后面的数组是排好序的
     * 3.特殊的情况,也就是原始的数组以本身的中位数进行旋转的时候, 前面和后面都是升序的
     * <p>
     * 先不考虑特殊的情况,因为题目的要求时间复杂度为log(n)所以用到了二分查找,但是二分查找的前提是有序的数组
     * 所以解决该类问题的时候需要不断的找出排好序的数组用二分查找去进行搜索
     */
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        //定义左指针
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //前面是升序
            if (nums[mid] >= nums[left]) {
                //target是否在前面的序列中(target<nums[mid]不可能等于,如果是等于的情况下前面就直接return了)
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
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
