package 穆帆.排序;


/**
 * @author mufan
 * @date 2020/7/3
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return generateBST(nums, 0, nums.length - 1);
    }

    private TreeNode generateBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right-left)/2+left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateBST(nums, left, mid - 1);
        root.right = generateBST(nums, mid + 1, right);
        return root;
    }
}
