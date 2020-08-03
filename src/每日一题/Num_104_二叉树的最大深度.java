package 每日一题;

/**
 * @author mufan
 * @date 2020/7/28
 */
class Num_104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
