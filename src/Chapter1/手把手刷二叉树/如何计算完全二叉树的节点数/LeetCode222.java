package Chapter1.手把手刷二叉树.如何计算完全二叉树的节点数;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode222 {

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

    //常规的二叉树写法
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
//
    //满二叉树的写法
//    public int countNodes(TreeNode root) {
//        int h = 0;
//        int count;
//        while (root != null) {
//            h++;
//            root = root.left;
//        }
//        count = (int) Math.pow(h, 2) - 1;
//        return count;
//    }

    //那么完全二叉树就是普通二叉树和满二叉树的结合
    public int countNodes(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;
        int hl = 0;
        int hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }

        if (hl == hr) {
            return (int) Math.pow(2,hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
