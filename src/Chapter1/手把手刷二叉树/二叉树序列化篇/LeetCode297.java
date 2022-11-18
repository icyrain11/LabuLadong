package Chapter1.手把手刷二叉树.二叉树序列化篇;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        String SEP = ",";
        String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }


            sb.append(root.val).append(SEP);

            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        public TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            //前序遍历
            String first = nodes.removeFirst();
            if (first.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(first));
            //前序遍历
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }

    }
}
