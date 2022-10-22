package Chapter1.手把手刷二叉树.二叉搜索树第一期;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCoce1038 {
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

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    int sum = 0;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }



}
