package Chapter0.手把手带你刷二叉树;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode543 {
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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        //对每个节点进行计算,求最大直径
        traves(root);
        return maxDiameter;
    }

    public void traves(TreeNode root) {
        if (root == null) {
            return;
        }
        //对每一个节点都进行计算
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        //更新全局遍历
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        traves(root.left);
        traves(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
