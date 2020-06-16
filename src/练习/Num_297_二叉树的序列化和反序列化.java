package 练习;

import java.util.*;

/**
 * @author mufan
 * @date 2020/6/16
 */
public class Num_297_二叉树的序列化和反序列化 {

    public String serialize(TreeNode root) {
        StringBuilder sb = serializeHelp(root, new StringBuilder());
        return sb.toString();
    }

    private StringBuilder serializeHelp(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return sb;
        }
        sb.append(root.val).append(",");
        sb = serializeHelp(root.left, sb);
        sb = serializeHelp(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        List<String> listWord = new LinkedList<>(Arrays.asList(str));
        return deserializeHelp(listWord);
    }

    private TreeNode deserializeHelp(List<String> listWord) {
        if (listWord.get(0).equals("null")) {
            listWord.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.parseInt(listWord.get(0)));
        listWord.remove(0);
        res.left = deserializeHelp(listWord);
        res.right = deserializeHelp(listWord);
        return res;
    }

}
