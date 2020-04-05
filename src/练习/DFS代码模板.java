package 练习;

import java.util.List;
import java.util.Stack;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class DFS代码模板 {
    /**
     * 递归
     */
    public void dfs(Node node, List<Node> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);

        //process current node here

        for (Node nextNode : node.children) {
            if (!visited.contains(nextNode)) {
                dfs(node, visited);
            }
        }
    }

    /**
     * 非递归
     */
    public void dfs1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();

            //process current node here

            stack.addAll(node.children);
        }
    }


}
