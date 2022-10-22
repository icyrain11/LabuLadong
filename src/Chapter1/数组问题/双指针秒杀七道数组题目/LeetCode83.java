package Chapter1.数组问题.双指针秒杀七道数组题目;

/**
 * 删除排序链表中的重复元素
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        //base case
        if (head == null) return null;
        ListNode slow = head, fast = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                //slow = slow++
                slow = slow.next;
            }
            //fast++
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
