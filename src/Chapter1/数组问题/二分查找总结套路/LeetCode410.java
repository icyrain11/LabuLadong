package Chapter1.数组问题.二分查找总结套路;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode410 {
    class Solution {

        public int splitArray(int[] nums, int m) {
            return shipWithinDays(nums, m);
        }

        public int shipWithinDays(int[] weights, int days) {
            int left = 0;
            int right = 1;
            for (int w : weights) {
                left = Math.max(left, w);
                right += w;
            }

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(weights, mid) <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
        // f(x) 随着 x 的增加单调递减
        int f(int[] weights, int x) {
            int days = 0;
            for (int i = 0; i < weights.length; ) {
                // 尽可能多装货物
                int cap = x;
                while (i < weights.length) {
                    if (cap < weights[i]) {
                        break;
                    } else {
                        cap -= weights[i];
                    }
                    i++;
                }
                days++;
            }
            return days;
        }
    }

}


