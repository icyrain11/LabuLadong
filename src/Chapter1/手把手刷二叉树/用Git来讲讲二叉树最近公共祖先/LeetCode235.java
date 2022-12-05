package Chapter1.手把手刷二叉树.用Git来讲讲二叉树最近公共祖先;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val1 较小，val2 较大
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

//    //常规的解法
//    public TreeNode find(TreeNode root, int val1, int val2) {
//        if (root == null) {
//            return null;
//        }
//
//        //判断该节点是否为目标节点
//        if (root.val == val1 || root.val == val2) {
//            return root;
//        }
//
//        TreeNode left = find(root.left, val1, val2);
//        TreeNode right = find(root.right, val1, val2);
//
//        //作为父节点返回
//        if (left != null && right != null) {
//            return root;
//        }
//
//        return left != null ? left : right;
//    }

    //利用BST的性质解题
    public TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        //去左子树
        if (root.val > val2) {
            return find(root.left, val1, val2);
        }
        //去右子树找
        if (root.val < val1) {
            return find(root.right, val1, val2);
        }

        return root;
    }
}
