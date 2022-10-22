package Chapter1.手把手刷链表题目.双指针技巧秒杀七道链表题目;

/**
 * 环形链表
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode141 {

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

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;

        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


}
