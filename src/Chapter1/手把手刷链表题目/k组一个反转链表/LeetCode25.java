package Chapter1.手把手刷链表题目.k组一个反转链表;

/**
 * k组一个反转链表
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode25 {

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


    //反转链表
    ListNode reverse(ListNode a) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;

        while (cur != null) {
            nxt = cur.next;
            //反转
            cur.next = pre;
            //都向下移动
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    //[a,b)反转
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            //继续移动
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    //k个一组反转
    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a, b;
        a = b = head;

        for (int i = 0; i < k; i++) {
            //不足k个一组
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        //反转k个
        ListNode newHead = reverse(a, b);
        //将两条链表连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

}
