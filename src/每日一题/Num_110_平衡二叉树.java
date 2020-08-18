package 每日一题;

/**
 * @author mufan
 * @date 2020/8/18
 */
public class Num_110_平衡二叉树 {
    /**
     * 从底至顶
     */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 从顶至底
     */
    public boolean isBalanced1(TreeNode root) {
        return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
