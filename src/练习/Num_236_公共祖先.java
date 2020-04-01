package 练习;

/**
 * @author mufan
 * @date 2020/4/1
 */
public class Num_236_公共祖先 {
    /**
     * 公共祖先
     * 1.p,q要么同时在左子树，要么同时在右子树，要么就是分别在左右子树
     * 2.左子树没有那肯定是在右子树，因为根节点只有一个。
     * 3.左右子树都没有肯定是在根节点
     * 4.找公共节点的前提条件一定要清楚
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
