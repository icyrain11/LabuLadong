package Chapter0.LeetCodeNSum问题;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("All")
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return NSum(nums, 4, 0, target);
    }

    public List<List<Integer>> NSum(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //如果是towSum,且数组不因该小于n
        if (n < 2 || size < n) {
            return result;
        }
        //towSum是base case
        if (n == 2) {
            //双指针操作
            int lo = start, hi = size - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    temp.add(right);
                    result.add(temp);
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            //n>2时递归计算(n-1)Sum结果
            for (int i = start; i < size; i++) {
                List<List<Integer>> sub = NSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    result.add(arr);
                }
                while (i < size - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return result;
    }


}
