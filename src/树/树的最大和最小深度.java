package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/1/7
 */
public class 树的最大和最小深度 {
    /**
     * 树的最小深度
     * DFS
     */
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
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 题目有点小坑，需要注意。
     * 对于一个根节点来说，如果它的左子树或者又子树为空，那么为空的那一方不存在叶子节点。
     *  1
     * /
     * 2
     * 对于上面[1, 2]；
     * 右子树为空，但右子树没有叶子节点；
     * 不能够求，只能够求它的左子树的最小深度
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                } else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 树的最大深度
     * DFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            length++;
        }
        return length;
    }
}
