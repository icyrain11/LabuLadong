package LeetCodeWeekRank.三百二十一场;

import java.util.Stack;

/**
 * @author icyrain11
 * @version 1.8
 */


public class LeetCode6247 {

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


    //单调栈
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;


        //放最大值在栈底
        stack.push(dummy);
        ListNode cur = head;

        while (cur != null) {
            // 单调递减栈，所以需要把小于 curr 得节点都删除
            while (!stack.isEmpty() && cur.val > stack.peek().val) {
                stack.pop();
            }
            stack.peek().next = cur;
            stack.push(cur);
            cur = cur.next;
        }

        return dummy.next;
    }


}
