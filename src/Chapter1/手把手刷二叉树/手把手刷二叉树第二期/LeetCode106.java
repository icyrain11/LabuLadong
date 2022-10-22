package Chapter1.手把手刷二叉树.手把手刷二叉树第二期;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCode106 {

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


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd) {
        if (inStart > inEnd) {
            return null;
        }

        //root对于的值就是postorder最后的一个值
        int rootval = postorder[posEnd];

        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootval) {
                index = i;
                break;
            }
        }

        int leftsize = index - inStart;
        TreeNode root = new TreeNode(rootval);
        root.left = build(inorder, inStart, index - 1, postorder, posStart, leftsize + posStart - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, leftsize + posStart, posEnd - 1);
        return root;
    }
}
