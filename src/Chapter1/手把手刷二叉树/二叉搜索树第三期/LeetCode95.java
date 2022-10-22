package Chapter1.手把手刷二叉树.二叉搜索树第三期;

import java.util.LinkedList;
import java.util.List;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCode95 {
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return count(1, n);
    }

    public List<TreeNode> count(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }

        //穷举root
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> lefttree = count(lo, i - 1);
            List<TreeNode> righttree = count(i + 1, hi);
            //枚举出所有节点的可能
            for (TreeNode left : lefttree) {
                for (TreeNode right : righttree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
