package Chapter1.手把手刷二叉树.二叉树构造篇;

/**
 * @author icyrain11
 * @version 1.8
 */
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
        //1.优先队列
        //2.遍历数组确定大小并确定其index
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxValue = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        //构建左右子树
        root.left = build(nums, start, index - 1);
        root.right = build(nums, index + 1, end);
        return root;
    }
}
