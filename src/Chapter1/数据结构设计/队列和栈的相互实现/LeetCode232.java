package Chapter1.数据结构设计.队列和栈的相互实现;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.Stack;

public class LeetCode232 {


    //用栈实现队列
    class MyQueue {
        private Stack<Integer> s1, s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * 添加元素到队尾
         */
        public void push(int x) {
            s1.push(x);
        }

        /**
         * 删除队头的元素并返回
         */
        public int pop() {
            //先操作
            peek();
            return s2.pop();
        }

        /**
         * 返回队头元素
         */
        public int peek() {
            //如果s2为空
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        /**
         * 判断队列是否为空
         */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }



}

