package Chapter1.手把手刷二叉树.二叉树纲领篇;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode104 {

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

    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;


    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            //到达叶子节点更新深度
            res = Math.max(res, depth);
        }

        traverse(root.left);
        traverse(root.right);
        //后序位置
        depth--;
    }
}
