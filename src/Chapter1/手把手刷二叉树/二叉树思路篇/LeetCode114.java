package Chapter1.手把手刷二叉树.二叉树思路篇;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode114 {
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

    public void flatten(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        //后序遍历位置
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;

    }


}
