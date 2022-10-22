package Chapter1.手把手刷链表题目.判断回文链表;

import Chapter1.手把手刷链表题目.k组一个反转链表.LeetCode25;

/**
 * 判断回文链表
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode234 {


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

    //最初始的版本
//
//    // 左侧指针
//    ListNode left;
//
//    boolean isPalindrome(ListNode head) {
//        left = head;
//        return traverse(head);
//    }
//
//    boolean traverse(ListNode right) {
//        if (right == null) return true;
//        boolean res = traverse(right.next);
//        // 后序遍历代码
//        res = res && (right.val == left.val);
//        left = left.next;
//        return res;
//    }


    //优化版本
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        //快慢指针
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //奇偶问题
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

//    递归反转
//    public  ListNode reverse(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode last = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
//    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
