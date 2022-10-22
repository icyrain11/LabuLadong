package Chapter1.手把手刷二叉树.归并排序详解及应用;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode493 {

    class Solution {
        public int reversePairs(int[] nums) {
            // 执行归并排序
            sort(nums);
            return count;
        }

        private int[] temp;

        public void sort(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
        }

        // 归并排序
        private void sort(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }

        // 记录「翻转对」的个数
        private int count = 0;

        private void merge(int[] nums, int lo, int mid, int hi) {
            for (int i = lo; i <= hi; i++) {
                temp[i] = nums[i];
            }

            // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
            // 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
            int end = mid + 1;
            for (int i = lo; i <= mid; i++) {
                // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 long
                while (end <= hi && (long) nums[i] > (long) nums[end] * 2) {
                    end++;
                }
                count += end - (mid + 1);
            }

            // 数组双指针技巧，合并两个有序数组
            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    nums[p] = temp[j++];
                } else if (j == hi + 1) {
                    nums[p] = temp[i++];
                } else if (temp[i] > temp[j]) {
                    nums[p] = temp[j++];
                } else {
                    nums[p] = temp[i++];
                }
            }
        }

    }

}
