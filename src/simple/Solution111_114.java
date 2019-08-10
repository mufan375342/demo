package simple;


/**
 * @author mufan
 * @time 2019/8/9
 * 二叉树的最大深度和最小深度
 */
public class Solution111_114 {

    private int mindepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return mindepth(root.right) + 1;
        }
        if (root.right == null) {
            return mindepth(root.left) + 1;
        }
        int right = mindepth(root.right);
        int left = mindepth(root.left);
        return Math.min(right, left) + 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer left = maxDepth(root.left);
        Integer right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
