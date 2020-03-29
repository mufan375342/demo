package 树;

import java.util.*;

/**
 * @author mufan
 * @date 2019/12/26
 * https://www.jianshu.com/p/456af5480cee
 */
public class 树的中序前序后续遍历 {
    /**
     * 树的前序遍历(根节点-->左节点-->右节点)
     */
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /*          1
     *      2       3
     *  4             5
     *      6
     *  7       8
     */
    public void preOrderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
    }


    /**
     * 树的中序遍历(左节点-->根节点-->右节点)
     */
    public void sequentialTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        sequentialTraversal(root.left);
        System.out.print(root.val + " ");
        sequentialTraversal(root.right);
    }

    /*          1
     *      2       3
     *  4             5
     *      6
     *  7       8
     */
    public void sequentialTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.left);
                root = pop.right;
            }
        }
    }

    /**
     * 树的后序遍历(左节点-->右节点-->根节点)
     */
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    // 非递归后序遍历
    public void postOrderTraversal1(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }

    // 非递归后序遍历
    public List<Integer> postOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode lastVisited = root;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode peek = stack.peek();
            //这一步有两种情况,右子树为空或者右子树已经被访问了
            if (peek.right == null || lastVisited == peek.right) {
                list.add(peek.val);
                stack.pop();
                lastVisited = peek;

            } else {
                root = peek.right;
            }
        }
        return list;
    }

    public List<Integer> test(Node node) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (node == null) {
            return res;
        }
        dfs(node, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        List<Node> childrens = node.children;
        for (Node children : childrens) {
            dfs(children, res);
        }
        res.add(node.val);
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

    /*public static void main(String[] args) {
     *//*          1
     *      2       3
     *  4             5
     *      6
     *  7       8
     *//*
        //先序：1 2 4 6 7 8 3 5
        //中序：4 7 6 8 2 1 3 5
        //后序：7 8 6 4 2 5 3 1
        树的中序前序后续遍历 test = new 树的中序前序后续遍历();
        test.postOrderTraversal1(getTestTree());
//        test.preOrderTraversal(getTestTree());
        aa(getTestTree());
//        test.postOrderTraversal(getTestTree());
    }
*/
    public static void aa(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.val);
            node = node.right;
        }
    }

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(track);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    private static List<String> charToString(char[][] array) {
        char[][] arr = new char[8][8];
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] arr = new char[8][8];
        List<String> result = new LinkedList<>();
        for (char[] chars : arr) {
            String s = String.valueOf(chars);
            result.add(String.valueOf(chars));
        }
        System.out.println(result);
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root = pop.right;
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < deque.size(); i++) {
                TreeNode poll = deque.poll();
                li.add(poll.val);
                if (poll.left != null) {
                    deque.push(poll.left);

                }
                if (poll.right != null) {
                    deque.push(poll.right);
                }
            }
            list.add(li);
        }
        return list;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 1, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }

}
