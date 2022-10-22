package Chapter1.数组问题.差分数组;

/**
 * @author icyrain11
 * @version 1.8
 */

@SuppressWarnings("All")
public class LeetCode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        // 最多有 1000 个车站
        int[] nums = new int[1001];
        Difference df = new Difference(nums);
        for (int[] trip : trips) {
            //乘客数量
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            df.incerment(i, j, val);
        }
        int[] res = df.result();
        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
    }

    class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            if (nums.length > 0) {
                diff = new int[nums.length];
                diff[0] = nums[0];
                for (int i = 1; i < diff.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i - 1];
            }
            return res;
        }

        public void incerment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }
    }
}
