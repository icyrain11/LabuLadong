package Chapter1.数组问题.前缀和数组;

import java.util.HashMap;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode560 {

//    int subarraySum(int[] nums, int k) {
//        int n = nums.length;
//        // 构造前缀和
//        int[] preSum = new int[n + 1];
//        preSum[0] = 0;
//        for (int i = 0; i < n; i++)
//            preSum[i + 1] = preSum[i] + nums[i];
//
//        int res = 0;
//        // 穷举所有子数组
//        for (int i = 1; i <= n; i++)
//            for (int j = 0; j < i; j++)
//                // 子数组 nums[j..i-1] 的元素和
//                if (preSum[i] - preSum[j] == k)
//                    res++;
//
//        return res;
//    }

    /**
     * 优化版本
     */
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer>
                preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);

//       preSum[i] - preSum[j] == k => if (preSum[j] == preSum[i] - k)
//            res++;

        int res = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j)) {
                res += preSum.get(sum0_j);
            }
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
