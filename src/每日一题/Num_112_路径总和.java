package 每日一题;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/7/7
 */
public class Num_112_路径总和 {
    /**
     * dfs
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * bfs
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new ArrayDeque<>();
        Queue<Integer> queValue = new ArrayDeque<>();
        queNode.add(root);
        queValue.add(root.val);
        while (!queNode.isEmpty()) {
            TreeNode curNode = queNode.poll();
            Integer temp = queValue.poll();
            if (curNode.left == null && curNode.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (curNode.left != null) {
                queNode.add(root.left);
                queValue.add(root.left.val + temp);
            }
            if (curNode.right != null) {
                queNode.add(root.right);
                queValue.add(root.right.val + temp);
            }
        }
        return false;

    }
}
