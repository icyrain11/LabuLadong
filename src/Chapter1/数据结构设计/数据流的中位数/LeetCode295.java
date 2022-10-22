package Chapter1.数据结构设计.数据流的中位数;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.PriorityQueue;

public class LeetCode295 {

    class MedianFinder {

        private PriorityQueue<Integer> large;
        private PriorityQueue<Integer> small;

        public MedianFinder() {
            //小顶堆
            large = new PriorityQueue<>();
            //大顶堆
            small = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            //如果元素不一样多,那么多出来的元素就是中文数
            if (large.size() > small.size()) {
                return large.peek();
            } else if (large.size() < small.size()) {
                return small.peek();
            }

            return (large.peek() + small.peek()) / 2.0;
        }
    }
}
