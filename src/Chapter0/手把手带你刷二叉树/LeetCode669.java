package Chapter0.手把手带你刷二叉树;

/*
 * @author icyrain11~
 * @version 16
 */


public class LeetCode669 {

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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        //如果在区间中不错处理
        trimBST(root.left, low, high);
        trimBST(root.right, low, high);

        return root;
    }
}
