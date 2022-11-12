package Chapter1.手把手刷二叉树.二叉树纲领篇;

/**
 * @author icyrain11
 * @version 1.8
 */
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

//    int maxDiameter = 0;
//
//    public int diameterOfBinaryTree(TreeNode root) {
//        traverse(root);
//        return maxDiameter;
//    }
//
//    public void traverse(TreeNode root) {
//        //base case
//        if (root == null) {
//            return;
//        }
//
//        int leftMax = maxDepth(root.left);
//        int rightMax = maxDepth(root.right);
//        int myDiameter = leftMax + rightMax;
//        maxDiameter = Math.max(maxDiameter, myDiameter);
//
//        traverse(root.left);
//        traverse(root.right);
//    }
//
//    public int maxDepth(TreeNode root) {
//        //base case
//        if (root == null) {
//            return 0;
//        }
//        int leftMax = maxDepth(root.left);
//        int rightMax = maxDepth(root.right);
//        return 1 + Math.max(leftMax, rightMax);
//    }

    //后序遍历优化
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        //后序位置进行计算
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(myDiameter, maxDiameter);
        //返回该层次的子树信息
        return 1 + Math.max(leftMax, rightMax);
    }
}
