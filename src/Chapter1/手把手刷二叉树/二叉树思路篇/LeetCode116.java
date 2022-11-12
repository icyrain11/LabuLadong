package Chapter1.手把手刷二叉树.二叉树思路篇;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


//    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//        traverse(root.left, root.right);
//        return root;
//    }
//
//    public void traverse(Node left, Node right) {
//        if (left == null || right == null) {
//            return;
//        }
//        left.next = right;
//
//        //连接
//        traverse(left.left, left.right);
//        traverse(right.left, right.right);
//
//        //不同子树节点连接
//        traverse(left.right, right.left);
//    }
    //试试看层序遍历
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node[] nodeList = new Node[size];
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                nodeList[i] = cur;
                //如果左右子树不为空
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            for (int i = 1; i < size; i++) {
                nodeList[i - 1].next = nodeList[i];
            }
            nodeList[size - 1].next = null;
        }
        return root;
    }

}
