package Chapter1.手把手刷二叉树.手把手刷二叉树第二期;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootval = preorder[preStart];
        int leftval = preorder[preStart + 1];
        int index = 0;
        for (int i = postStart; i < postEnd; i++) {
            if (postorder[i] == leftval) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootval);
        int leftsize = index - postStart + 1;
        root.left = build(preorder, preStart + 1, preStart + leftsize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftsize + 1, preEnd,
                postorder, index + 1, postEnd - 1);
        return root;
    }

}
