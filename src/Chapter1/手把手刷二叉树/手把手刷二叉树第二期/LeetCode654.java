package Chapter1.手把手刷二叉树.手把手刷二叉树第二期;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int lo, int hi) {
        //base case
        if (lo > hi) {
            return null;
        }

        //从数组中找到最大数组的索引
        int index = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > maxVal) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, 0, index - 1);
        root.right = build(nums, index + 1, nums.length - 1);
        return root;
    }
}
