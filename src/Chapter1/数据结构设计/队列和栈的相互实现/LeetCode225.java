package Chapter1.数据结构设计.队列和栈的相互实现;

/*
 * @author icyrain11~
 * @version 16
 */


import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {
    class MyStack {
        Queue<Integer> q = new LinkedList<>();
        int top_elem = 0;

        /**
         * 添加元素到栈顶
         */
        public void push(int x) {
            //x是队列的队尾,是栈的栈顶
            q.offer(x);
            top_elem = x;
        }

        /**
         * 删除栈顶的元素并返回
         */
        public int pop() {
            int size = q.size();
            while (size > 2) {
                q.offer(q.poll());
                size--;
            }
            top_elem = q.peek();
            q.offer(q.poll());
            return q.poll();
        }

        /**
         * 返回栈顶元素
         */
        public int top() {
            return top_elem;
        }

        /**
         * 判断栈是否为空
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
