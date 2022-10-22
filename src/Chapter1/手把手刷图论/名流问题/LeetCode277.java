package Chapter1.手把手刷图论.名流问题;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.LinkedList;

@SuppressWarnings("All")
public class LeetCode277 {

    // 可以直接调用，能够返回 i 是否认识 j
    public boolean knows(int i, int j) {
        return true;
    }

    // 请你实现：返回「名人」的编号
//    int findCelebrity(int n) {
//        for (int cand = 0; cand < n; cand++) {
//            int other;
//            for (other = 0; other < n; other++) {
//                if (cand == other) {
//                    continue;
//                }
//                // 保证其他人都认识 cand，且 cand 不认识任何其他人
//                // 否则 cand 就不可能是名人
//                if (knows(cand, other) || !knows(other, cand)) {
//                    break;
//                }
//            }
//            if (other == n) {
//                return cand;
//            }
//        }
//        return -1;
//    }


    //优化算法
//    int findCelebrity(int n) {
//        if (n == 1) {
//            return 0;
//        }
//        LinkedList<Integer> q = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            q.addLast(i);
//        }
//
//        //一直排除,直到只剩下一个候选人为止
//        while (q.size() >= 2) {
//            int cand = q.removeFirst();
//            int other = q.removeLast();
//            if (knows(cand, other) || !knows(other, cand)) {
//                // cand 不可能是名人，排除，让 other 归队
//                q.addFirst(other);
//            } else {
//                // other 不可能是名人，排除，让 cand 归队
//                q.addFirst(cand);
//            }
//        }
//
//        // 现在排除得只剩一个候选人，判断他是否真的是名人
//        int cand = q.removeLast();
//        for (int other = 0; other < n; other++) {
//            if (other == cand) {
//                continue;
//            }
//            if (!knows(other, cand) || knows(cand, other)) {
//                return -1;
//            }
//        }
//        return cand;
//    }

    //最终写法
    int findCelebrity(int n) {
        // 先假设 cand 是名人
        int cand = 0;
        for (int other = 0; other < n; other++) {
            if (!knows(other, cand) || knows(cand, other)) {
                // cand 不可能是名人，排除
                // 假设 other 是名人
                cand = other;
            } else {
                // other 不可能是名人，排除
                // 什么都不用做，继续假设 cand 是名人
            }
        }

        // 现在的 cand 是排除的最后结果，但不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (cand == other) {
                continue;
            }
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }
        return cand;
    }
}
