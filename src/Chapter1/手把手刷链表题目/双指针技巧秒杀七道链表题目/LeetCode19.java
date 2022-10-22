package Chapter1.手把手刷链表题目.双指针技巧秒杀七道链表题目;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode19 {

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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //查出该删除的节点
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }

    //倒数
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}
