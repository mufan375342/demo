package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/1/7
 */
@SuppressWarnings("all")
public class 树的层次遍历 {
    /**
     * 广度优先搜索（BFS）
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 深度优先搜索
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        DFS(root, 1, res);
        return res;
    }

    /**
     * 这里只能用递归实现,不能使用循环,循环就牵扯到了回溯的问题
     */
    private void DFS(TreeNode root, int level, List<List<Integer>> res) {
        if(root==null){
            return;
        }
        if(res.size()<level){
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(root.val);
        DFS(root.left,level+1,res);
        DFS(root.right,level+1,res);
    }




    public static TreeNode getTestTree() {
        TreeNode[] nodes = new TreeNode[9];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[1].left = nodes[2];
        nodes[1].right = nodes[3];
        nodes[2].left = nodes[4];
        nodes[3].right = nodes[5];
        nodes[4].right = nodes[6];
        nodes[6].left = nodes[7];
        nodes[6].right = nodes[8];
        return nodes[1];
    }

    public static void main(String[] args) {
        /*          1
         *      2       3
         *  4             5
         *      6
         *  7       8
         */
        //先序：1 2 4 6 7 8 3 5
        //中序：4 7 6 8 2 1 3 5
        //后序：7 8 6 4 2 5 3 1
        树的层次遍历 test = new 树的层次遍历();
//        test.preOrderTraversal(getTestTree());
        List<List<Integer>> lists = test.levelOrder1(getTestTree());
        System.out.println(123);
//        test.postOrderTraversal(getTestTree());
    }
}
