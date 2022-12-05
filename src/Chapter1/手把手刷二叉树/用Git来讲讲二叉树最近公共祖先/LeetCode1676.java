package Chapter1.手把手刷二叉树.用Git来讲讲二叉树最近公共祖先;

import java.util.HashSet;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1676 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // 将列表转化成哈希集合，便于判断元素是否存在
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }

        return find(root, values);
    }

    public TreeNode find(TreeNode root, HashSet<Integer> values) {
        if (root == null) {
            return null;
        }

        //如果存在该值则返回作为子节点
        if (values.contains(root.val)) {
            return root;
        }

        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);

        //作为root节点返回
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
