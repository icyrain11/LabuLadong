package Chapter1.手把手刷二叉树.后序遍历的妙处;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode1373 {
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

    public int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        travel(root);
        return maxSum;
    }

    public int[] travel(TreeNode root) {
        //base case
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        //递归计算左右子树
        int[] left = travel(root.left);
        int[] right = travel(root.right);


        //后序遍历
        int[] res = new int[4];
        //在这个if中判断以root为根节点的二叉树是不是BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            //那么以root为节点的二叉搜索树就成立了
            res[0] = 1;
            //计算二叉搜索树BST的最小值
            res[1] = Math.min(left[1], root.val);
            //计算二叉搜索树的最大值
            res[2] = Math.max(right[2], root.val);
            //计算所有的root为根的左右子树总和
            res[3] = left[3] + right[3] + root.val;
            //更新全局变量
            maxSum = Math.max(res[3], maxSum);
        } else {
            res[0] = 0;
        }

        return res;
    }
}
