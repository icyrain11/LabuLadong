package Chapter1.手把手刷二叉树.用Git来讲讲二叉树最近公共祖先;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1650 {
    class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            // a 走一步，如果走到根节点，转到 q 节点
            if (a == null) {
                a = q;
            } else {
                a = a.parent;
            }
            // b 走一步，如果走到根节点，转到 p 节点
            if (b == null) {
                b = p;
            } else {
                b = b.parent;
            }
        }
        return a;
    }
}
