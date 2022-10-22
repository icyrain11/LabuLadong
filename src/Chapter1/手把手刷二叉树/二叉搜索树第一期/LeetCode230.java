package Chapter1.手把手刷二叉树.二叉搜索树第一期;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCode230 {
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


    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public int res;
    public int rank = 0;

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
