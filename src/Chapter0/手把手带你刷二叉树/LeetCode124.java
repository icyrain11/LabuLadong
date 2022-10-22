package Chapter0.手把手带你刷二叉树;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode124 {

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

    int res = Integer.MIN_VALUE;

    //最大直径问题就是在后序的BFS上优化
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算单边路径最大的和90+
        oneSizeMax(root);
        return res;
    }

    public int oneSizeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(0, oneSizeMax(root.left));
        int rightMax = Math.max(0, oneSizeMax(root.right));
        int pathMaxSum = root.val + leftMax + rightMax;

        res = Math.max(res, pathMaxSum);
        return Math.max(leftMax, rightMax) + root.val;
    }

}
