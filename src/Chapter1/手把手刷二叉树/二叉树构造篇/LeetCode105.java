package Chapter1.手把手刷二叉树.二叉树构造篇;

import java.util.HashMap;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode105 {

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

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
//    }
//
//    TreeNode build(int[] preorder, int preStart, int preEnd,
//                   int[] inorder, int inStart, int inEnd) {
//
//        if (preStart > preEnd) {
//            return null;
//        }
//
//        // root 节点对应的值就是前序遍历数组的第一个元素
//        int rootVal = preorder[preStart];
//        // rootVal 在中序遍历数组中的索引
//        int index = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == rootVal) {
//                index = i;
//                break;
//            }
//        }
//
//        int leftSize = index - inStart;
//
//        // 先构造出当前根节点
//        TreeNode root = new TreeNode(rootVal);
//        // 递归构造左右子树
//        root.left = build(preorder, preStart + 1, preStart + leftSize,
//                inorder, inStart, index - 1);
//
//        root.right = build(preorder, preStart + leftSize + 1, preEnd,
//                inorder, index + 1, inEnd);
//        return root;
//    }


    //用HashMap优化
    HashMap<Integer, Integer> valueToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //先确定根节点
        int rootVal = preorder[preStart];

        int index = valueToIndex.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        //左子树大小
        int leftSize = index - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
