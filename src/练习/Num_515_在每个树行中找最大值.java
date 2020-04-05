package 练习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_515_在每个树行中找最大值 {
    /**
     * BFS
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    /**
     * DFS
     */
    public static List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 1, res);
        return res;
    }

    private static void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() < level) {
            res.add(level - 1, Integer.MIN_VALUE);
        }
        //这里需要注意Set,而不是get
        res.set(level - 1, Math.max(res.get(level - 1), root.val));
        if (root.left != null) {
            dfs(root.left, level + 1, res);
        }
        if (root.right != null) {
            dfs(root.right, level + 1, res);
        }
    }

    public static TreeNode getTestTree1() {
        /*
         *       1
         *      / \
         *     3  2
         *    / \   \
         *   5   3   9
         */

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode53 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode53;
        treeNode2.right = treeNode9;
        return treeNode1;
    }

    public static void main(String[] args) {
        TreeNode testTree1 = getTestTree1();
        largestValues1(testTree1);

        List<Integer>list=new ArrayList<>();
        list.add(0,2);
        list.add(0,4);
        list.set(0,5);
        System.out.println(list.get(0));
    }
}
