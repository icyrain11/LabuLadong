package Chapter1.手把手刷链表题目.双指针技巧秒杀七道链表题目;

/**
 * 环形链表 II
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode142 {


    class ListNode {

        int val;

        ListNode next;


        ListNode(int x) {
            val = x;
            next = null;
        }

    }


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }


        //正好距离k-m
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
