package Chapter1.手把手刷链表题目.单链表六大套路;

/*
 * @author icyrain11~
 * @version 16
 */
public class LeetCode21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode l3 = new ListNode();
        ListNode res = l3;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            l3.next = l1;
            l3 = l3.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            l3.next = l2;
            l3 = l3.next;
            l2 = l2.next;
        }

        return res.next;
    }
}
