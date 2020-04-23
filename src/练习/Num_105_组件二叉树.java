package 练习;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/4/1
 */
public class Num_105_组件二叉树 {

    private int preIndex = 0;
    private int[] preOrder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        this.preOrder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int start, int end) {
        //terminator
        if (start == end) {
            return null;
        }
        //process
        int rootValue = preOrder[preIndex];
        TreeNode treeNode = new TreeNode(rootValue);

        Integer inorderIndex = map.get(rootValue);
        preIndex++;
        //这里的赋值操作很是关键不然串不起来
        treeNode.left = dfs(start, inorderIndex-1);
        treeNode.right = dfs(inorderIndex + 1, end);
        //drilldown
        return treeNode;
    }

}
