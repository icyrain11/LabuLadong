package Chapter0.LeetCodeNSum问题;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先给数组排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //穷举threeSum的第一个数
        for (int i = 0; i < n; i++) {
            //对target-nums[i]计算towsum
            List<List<Integer>> tuples = towSum(nums, i + 1, 0 - nums[i]);
            //如果存在二元组加上三元组的元素即可
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                result.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }

    public List<List<Integer>> towSum(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
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
                List<Integer> temp = new ArrayList<Integer>();
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
        return result;
    }

    @Test
    public void test() {

    }

}
