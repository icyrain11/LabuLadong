package Chapter1.手把手刷二叉树.二叉树构造篇;

import java.util.HashMap;
import java.util.Map;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode889 {
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

    Map<Integer, Integer> valueToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valueToIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, postorder, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        //找到根节点的值
        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        //左子树节点在下一个二叉树中的索引值
        int index = valueToIndex.get(leftRootVal);
        //左子树大小
        int leftSize = index - postStart + 1;

        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);
        return root;
    }
}
