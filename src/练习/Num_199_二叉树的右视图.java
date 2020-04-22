package 练习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author mufan
 * @date 2020/4/22
 */
public class Num_199_二叉树的右视图 {

    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                if (i + 1 == size) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }


    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int depth = 0;
        dfs(root, depth, list);
        return list;
    }

    private void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(root.val);
        }
        depth++;
        dfs(root.right, depth, list);
        dfs(root.left, depth, list);
    }
}
