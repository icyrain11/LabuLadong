package Chapter1.手把手刷二叉树.用Git来讲讲二叉树最近公共祖先;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) {
            return null;
        }
        //情况2
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //情况1
        if (left != null && right != null) {
            return root;
        }

        //情况2
        if (left == null && right == null) {
            return null;
        }

        //情况3
        return left == null ? right : left;
    }
}
