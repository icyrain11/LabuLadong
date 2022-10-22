package Chapter1.手把手刷链表题目.双指针技巧秒杀七道链表题目;

/**
 * 链表的中间结点
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode876 {

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


    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null) {
            //快指针走一步
            slow = slow.next;
            //慢指针走两步
            fast = fast.next.next;
        }

        //中间节点
        return slow;
    }

    //判断链表是否有环
    boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }

}
