package 练习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/4/1
 */
public class Num_429_N叉树的遍历 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 1, res);
        return res;
    }

    private void dfs(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (level > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), level + 1, res);
        }
    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node no = queue.poll();
                li.add(no.val);
                List<Node> children = no.children;
                for (Node node : children) {
                    queue.add(node);
                }
            }
            res.add(li);
        }
        return res;
    }
}
