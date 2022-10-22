package Chapter1.手把手刷链表题目.递归反转链表的一部分;

/*
 反转单链表
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode206 {
    // 单链表节点的结构
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    //递归实现逆转链表
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }


}
