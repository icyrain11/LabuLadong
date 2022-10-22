package Chapter1.手把手刷链表题目.双指针技巧秒杀七道链表题目;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode23 {


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


    public ListNode mergeKLists(ListNode[] lists) {
        //特殊情况先处理
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        //虚拟节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        //将头节点加入到优先队列中
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        //开始合并
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }


        return dummy.next;
    }
}
