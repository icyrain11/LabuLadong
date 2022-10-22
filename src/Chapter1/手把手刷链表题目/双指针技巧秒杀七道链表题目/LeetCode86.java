package Chapter1.手把手刷链表题目.双指针技巧秒杀七道链表题目;

/**
 * 单链表的分解
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode86 {


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


    public ListNode partition(ListNode head, int x) {
        //小值链表
        ListNode dummy1 = new ListNode(-1);

        //大值链表
        ListNode dummy2 = new ListNode(-1);

        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;

        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;

        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }

            //断开原链表
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }


        p1.next = dummy2.next;
        return dummy1.next;
    }


}
