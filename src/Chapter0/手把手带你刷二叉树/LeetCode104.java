package Chapter0.手把手带你刷二叉树;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCode104 {
    //最大深度
    int res = 0;
    //当前深度
    int depth = 0;

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

//    public int maxDepth(TreeNode root) {
//        traverse(root);
//        return res;
//    }
//
//    public void traverse(TreeNode root) {
//        //结束条件
//        if (root == null) {
//            res = Math.max(depth, res);
//            return;
//        }
//        //谦虚遍历
//        depth++;
//        traverse(root.left);
//        traverse(root.right);
//        //后序位置
//        depth--;
//    }

    //合并之后的代码
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        int res = Math.max(leftMax, rightMax) + 1;

        return res;
    }

}
