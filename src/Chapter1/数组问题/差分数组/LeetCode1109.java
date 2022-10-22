package Chapter1.数组问题.差分数组;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        Difference df = new Difference(new int[n]);
        for (int[] booking : bookings) {
            int i = booking[0]-1;
            int j = booking[1]-1;
            int val = booking[2];
            df.increment(i, j, val);
        }
        return df.result();
    }

    class Difference {
        int[] diff;

        public Difference(int[] nums) {
            int n = nums.length;
            diff = new int[n];
            diff[0] = nums[0];
            for (int i = 1; i < n; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j+1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
