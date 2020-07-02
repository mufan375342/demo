package 每日一题;

/**
 * @author mufan
 * @date 2020/7/2
 */
public class Num_378_有序矩阵中第K小的元素 {

    public int kthSmallest(int[][] matrix, int k) {
        int right = matrix[matrix.length - 1][matrix.length - 1];
        int left = matrix[0][0];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            //mid会将二维矩阵分为两部分,求小于mid的值有多少个，如果小于mid的值大于等于K,则right向左进行收缩，否则left向右进行收缩
            int num = 0;
            int row = 0;
            int col = matrix.length - 1;
            while (col >= 0 && row < matrix.length) {
                if (matrix[row][col] <= mid) {
                    num += col + 1;
                    row++;
                } else {
                    col--;
                }
            }
            if (num >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
