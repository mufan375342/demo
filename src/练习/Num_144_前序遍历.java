package 练习;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mufan
 * @date 2020/4/1
 */
public class Num_144_前序遍历 {
    private List<Integer> list = new ArrayList<>();

    /**
     * 递归
     */
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return list;
            }
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }

    /**
     * 迭代
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                list.add(root.val);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return list;
    }
}
