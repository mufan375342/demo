package 练习;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class BFS代码模板 {
    public void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node>queue=new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node node = queue.poll();

            //process curr node here

            queue.addAll(node.children);
        }
    }
}
