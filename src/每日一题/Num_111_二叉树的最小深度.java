package 每日一题;

/**
 * @author mufan
 * @date 2020/8/21
 */
public class Num_111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left, right) + 1;
    }
}
