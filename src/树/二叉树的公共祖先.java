package 树;

/**
 * @author mufan
 * @date 2019/12/31
 */
public class 二叉树的公共祖先 {

    public static TreeNode lowestComminAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*          6
         *      2       8
         *   0     4  7    9
         *      3    5
         */
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestComminAncestor(root.left, p, q);
        TreeNode right = lowestComminAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            //判断两个值是否都小于根节点
            if (p.val < root.val && q.val < root.val) {
                //直接排查左节点
                root = root.left;
            }
            //判断两个值是否都大于右节点
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode getTestTree() {
        /*            6
         *      2            8
         *   0     4      7    9
         *      3    5
         */
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode4.right=treeNode8;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

        return treeNode1;
    }

    public TreeNode getTestTree1() {
        /*
         *        4
         *     3    5
         */

        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(5);

        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

        return treeNode5;
    }

    public TreeNode getTestTree2() {
        return new TreeNode(5);
    }

    /*          6
     *      2       8
     *   0     4  7    9
     *      3    5
     */
    public static void main(String[] args) {
        二叉树的公共祖先 test = new 二叉树的公共祖先();
        TreeNode testTree = test.getTestTree();
        TreeNode testTree1 = test.getTestTree1();
        TreeNode testTree2 = test.getTestTree2();
        lowestComminAncestor(testTree, testTree1, testTree2);
    }
}
