package Chapter1.手把手刷链表题目.递归反转链表的一部分;

import org.junit.Test;

/*
反转 前k个链表 和 反转 m n之间的链表
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")

public class LeetCode92 {

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


    //中间反转
    ListNode reverseBetween(ListNode head, int m, int n) {

        //base case
        if (m == 1) {
            return reverseN(head, n);
        }

        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);

        return head;

    }


    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }



}
