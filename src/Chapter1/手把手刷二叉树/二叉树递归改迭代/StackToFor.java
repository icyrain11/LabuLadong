package Chapter1.手把手刷二叉树.二叉树递归改迭代;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("All")
public class StackToFor {
    //二叉树的递归改迭代
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

    //二叉树递归的框架
    void traverse(TreeNode root) {
        if (root == null) return;
        /* 前序遍历代码位置 */
        traverse(root.left);
        /* 中序遍历代码位置 */
        traverse(root.right);
        /* 后序遍历代码位置 */
    }



//    // 模拟函数调用栈
//    private Stack<TreeNode> stk = new Stack<>();
//
//    // 左侧树枝一撸到底
//    private void pushLeftBranch(TreeNode p) {
//        while (p != null) {
//            /*******************/
//            /** 前序遍历代码位置 **/
//            /*******************/
//            stk.push(p);
//            p = p.left;
//        }
//    }

//    public List<Integer> traverse(TreeNode root) {
//        // 指向上一次遍历完的子树根节点
//        TreeNode visited = new TreeNode(-1);
//        // 开始遍历整棵树
//        pushLeftBranch(root);
//
//        while (!stk.isEmpty()) {
//            TreeNode p = stk.peek();
//
//            // p 的左子树被遍历完了，且右子树没有被遍历过
//            if ((p.left == null || p.left == visited)
//                    && p.right != visited) {
//                /*******************/
//                /** 中序遍历代码位置 **/
//                /*******************/
//                // 去遍历 p 的右子树
//                pushLeftBranch(p.right);
//            }
//            // p 的右子树被遍历完了
//            if (p.right == null || p.right == visited) {
//                /*******************/
//                /** 后序遍历代码位置 **/
//                /*******************/
//                // 以 p 为根的子树被遍历完了，出栈
//                // visited 指针指向 p
//                visited = stk.pop();
//            }
//        }
//    }



    private Stack<TreeNode> stk = new Stack<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        // 记录后序遍历的结果
        List<Integer> postorder = new ArrayList<>();
        TreeNode visited = new TreeNode(-1);

        pushLeftBranch(root);
        while (!stk.isEmpty()) {
            TreeNode p = stk.peek();

            if ((p.left == null || p.left == visited)
                    && p.right != visited) {
                pushLeftBranch(p.right);
            }

            if (p.right == null || p.right == visited) {
                // 后序遍历代码位置
                postorder.add(p.val);
                visited = stk.pop();
            }
        }

        return postorder;
    }

    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
    }



}
