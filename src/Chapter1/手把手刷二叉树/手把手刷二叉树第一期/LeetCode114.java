package Chapter1.手把手刷二叉树.手把手刷二叉树第一期;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
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

        //后序遍历,左右子树扯平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //将左子树作为右子树
        root.left = null;
        root.right = left;

        //将原先的右子树接到左子树后
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }

}
