package 练习;

/**
 * @author mufan
 * @date 2020/6/14
 */
public class Num_1300_转变数组后最接近目标值的数组和 {

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        for (int num : arr) {
            right = Math.max(num, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = caculateSum(arr, mid);
            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int sum1 = caculateSum(arr, left - 1);
        int sum2 = caculateSum(arr, left);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    private int caculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, threshold);
        }
        return sum;
    }
}
