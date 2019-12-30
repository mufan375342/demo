package 树;

import java.util.Stack;

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
        树的中序前序后续遍历 test = new 树的中序前序后续遍历();
//        test.preOrderTraversal(getTestTree());
        test.postOrderTraversal1(getTestTree());
//        test.postOrderTraversal(getTestTree());
    }
}
