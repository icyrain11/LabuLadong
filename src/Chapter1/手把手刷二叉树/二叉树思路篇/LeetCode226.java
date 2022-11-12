package Chapter1.手把手刷二叉树.二叉树思路篇;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode226 {

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

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        //交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


        // 遍历框架，去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }

    //分解问题思路
//    // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
//    TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        // 利用函数定义，先翻转左右子树
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//
//        // 然后交换左右子节点
//        root.left = right;
//        root.right = left;
//
//        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
//        return root;
//    }
}
