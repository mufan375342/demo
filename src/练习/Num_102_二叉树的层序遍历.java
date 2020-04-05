package 练习;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, 1, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        //terminator
        if (root == null) {
            return;
        }
        //process
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);

        //drill down
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);

    }

    public List<List<Integer>> levelOrderOfBfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
