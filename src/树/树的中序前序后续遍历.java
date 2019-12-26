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

    public void postOrderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisit = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //查看当前栈顶元素
            root = stack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (root.right == null || root.right == lastVisit) {
                System.out.print(root.val + " ");
                stack.pop();
                lastVisit = root;
                root = null;
            } else {
                root = root.right;
            }
        }
    }

    public static TreeNode getTestTree() {
        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];
        nodes[3].left = nodes[7];
        nodes[3].right = nodes[8];
        nodes[4].left = nodes[9];
        return nodes[0];
    }

    public static void main(String[] args) {
        //前序：0 1 3 7 8 4 9 2 5 6
        //中序：7 3 8 1 9 4 0 5 2 6
        //后续：7 8 3 9 4 1 5 6 2 0
        树的中序前序后续遍历 test = new 树的中序前序后续遍历();
//        test.preOrderTraversal(getTestTree());
        test.sequentialTraversal(getTestTree());
//        test.postOrderTraversal(getTestTree());
    }
}
