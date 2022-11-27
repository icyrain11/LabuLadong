package LeetCodeWeekRank.三百二十一场;

import java.util.HashMap;
import java.util.Map;

/**
 * 等价转化
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode6248 {

    //TODO 没学会好难啊
    public int countSubarrays(int[] nums, int k) {
        int pos = 0, n = nums.length;
        while (nums[pos] != k) {
            pos++;
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        // i=pos 的时候 c 是 0，直接记到 cnt 中，这样下面不是大于就是小于
        cnt.put(0, 1);

        for (int i = pos + 1, c = 0; i < n; i++) {
            c += nums[i] > k ? 1 : -1;
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        // i=pos 的时候 c 是 0，直接加到答案中，这样下面不是大于就是小于
        int ans = cnt.get(0) + cnt.getOrDefault(1, 0);
        for (int i = pos - 1, c = 0; i >= 0; i--) {
            c += nums[i] < k ? 1 : -1;
            ans += cnt.getOrDefault(c, 0) + cnt.getOrDefault(c + 1, 0);
        }

        return ans;
    }

}
