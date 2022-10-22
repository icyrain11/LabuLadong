package Chapter1.手把手刷链表题目.双指针技巧秒杀七道链表题目;

/**
 * 相加链表
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode160 {

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


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            //继续走
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            //继续走
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
