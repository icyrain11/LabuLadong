package Chapter1.手把手刷链表题目.单链表六大套路;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.LinkedList;

@SuppressWarnings("All")
public class LeetCode160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            //p1走一步如果到A的末尾那么转到B链表
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            //p2走一步如果走到B链表末尾那么走链表A
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    //如果将两条链表的首尾连接到一起那么就转换成寻找环起点的问题这也是一种很好的转换
}
