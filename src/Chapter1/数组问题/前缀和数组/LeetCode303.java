package Chapter1.数组问题.前缀和数组;

/**
 * 区域和检测
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode303 {

    class NumArray {


        /*
         *这种方法效率太低了
         */
//        private int[] nums;
//        public NumArray(int[] nums) {
//            this.nums = nums;
//        }
//
//        public int sumRange(int left, int right) {
//            int count = 0;
//            for (int i = left; i <= right; i++) {
//                count += nums[i];
//            }
//            return count;
//        }

        // 前缀和数组
        private int[] preSum;

        /* 输入一个数组，构造前缀和 */
        public NumArray(int[] nums) {
            // preSum[0] = 0，便于计算累加和
            preSum = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        /* 查询闭区间 [left, right] 的累加和 */
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }


    }
}
