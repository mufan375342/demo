package 练习;

/**
 * @author mufan
 * @date 2020/4/12
 */
public class Num_74_二维矩阵搜索 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / col][mid % col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left / col][left % col] == target;
    }
}
