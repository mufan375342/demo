package 树;

import java.util.*;

/**
 * @author mufan
 * @date 2020/3/29
 */
public class N叉树的前序遍历 {
    /**
     * 1.首先想到的是bfs
     * 2.首先层次遍历每次遍历一层
     * 3.按照一层一层的打印，并且对于每一层来说都是先进先出。所以这时候需要用队列
     * 4.每一次打印都是打印本层数据然后将下一层的数据放入队列
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                List<Node> children = poll.children;
               for (Node node : children) {
                   queue.add(node);
               }
            }
            res.add(list);
        }
        return res;
    }
}
