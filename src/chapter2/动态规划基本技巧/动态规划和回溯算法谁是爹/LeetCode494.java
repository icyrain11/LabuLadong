package chapter2.动态规划基本技巧.动态规划和回溯算法谁是爹;

import java.util.HashMap;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode494 {


//    //这是递归自底向上解
//    int result = 0;
//
//    public int findTargetSumWays(int[] nums, int target) {
//        backtrack(nums, 0, target);
//        return result;
//    }
//
//    public void backtrack(int[] nums, int i, int remain) {
//        //base case
//        if (i == nums.length) {
//            //正好凑齐target
//            if (remain == 0) {
//                result++;
//            }
//            return;
//        }
//
//        //给nums[i]赋值-号
//        remain += nums[i];
//        backtrack(nums, i + 1, remain);
//        //撤销选择
//        remain -= nums[i];
//
//        //给nums[i]赋值+号
//        remain -= nums[i];
//        backtrack(nums, i + 1, remain);
//        //撤销选择
//        remain += nums[i];
//
//    }


    //dp解法
    int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
    }

    HashMap<String, Integer> memo = new HashMap<>();

    public int dp(int[] nums, int i, int remain) {
        //base case
        if (i == nums.length) {
            if (remain == 0) {
                return 1;
            }
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + remain;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        //记录备忘录
        memo.put(key, result);
        return result;
    }


}
