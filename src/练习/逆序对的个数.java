package 练习;



/**
 * @author mufan
 * @date 2020/4/25
 */
public class 逆序对的个数 {

    public static int reversePairs(int[] nums) {
        int len = nums.length;
        //如果数组的长度为1和0的时候就不会存在逆序对，所以这里 可以直接return
        if (len < 2) {
            return 0;
        }
        //为了不改边原始的数组，这里做一份拷贝
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);

    }

    public static int reversePairs(int[] nums, int left, int right, int[] temp) {
        //对数组进行拆分，拆分后进行合并，这里递归的终止条件是left==right,也就是说剩下一个数的时候肯定是一个有序的数组
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            //左边的已经放完了，将右边的拿上去
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = nums[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 1};
        int i = reversePairs(nums);
        System.out.println(i);
    }

}
