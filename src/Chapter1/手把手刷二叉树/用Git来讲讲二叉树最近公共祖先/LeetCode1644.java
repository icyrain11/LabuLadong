package Chapter1.手把手刷二叉树.用Git来讲讲二叉树最近公共祖先;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1644 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //用两个全局遍历记录是p,q节点是否存在树中
    boolean foundP = false, foundQ = false;

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root, p.val, q.val);
        if (!foundP || !foundQ) {
            return null;
        }
        // p 和 q 都存在二叉树中，才有公共祖先
        return res;
    }

    public TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        //TODO 位置变化顺序理解不了
        //因为是要遍历所有节点,那么需要改成后序遍历
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        //判断当前节点是否为LCA节点
        if (left != null && right != null) {
            return root;
        }


        if (root.val == val1 || root.val == val2) {
            // 找到了，记录一下
            if (root.val == val1) foundP = true;
            if (root.val == val2) foundQ = true;
            return root;
        }


        return left != null ? left : right;
    }
}
