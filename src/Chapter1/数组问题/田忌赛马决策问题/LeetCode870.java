package Chapter1.数组问题.田忌赛马决策问题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        //nums2降序排列
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );

        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }

        //给nums1升序
        Arrays.sort(nums1);


        //nums[left] 为最小值, nums[right] 为最大值
        int left = 0, right = n - 1;
        int[] res = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            int i = pair[0];
            int maxval = pair[1];

            if (maxval < nums1[right]) {
                //打得过就直接上
                res[i] = nums1[right];
                right--;
            } else {
                //用不行的蒙混过关
                res[i] = nums1[left];
                left++;
            }
        }

        return res;
    }
}
