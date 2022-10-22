package Chapter1.手把手刷二叉树.手把手刷二叉树第三期;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCode652 {

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

    public HashMap<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        //当前这颗二叉树的模样
        String subTree = left + "," + right + "," + root.val;

        int frequency = memo.getOrDefault(subTree, 0);

        if (frequency == 1) {
            res.add(root);
        }
        memo.put(subTree, frequency + 1);
        return subTree;
    }
}
