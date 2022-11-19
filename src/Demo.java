import java.util.*;

/**
 * @author icyrain11
 * @version 1.8
 */
public class Demo {

    class Merge {
        //临时数组
        private int[] temp;

        public int count = 0;

        public void sort(int[] nums) {
            int n = nums.length;
            temp = new int[n];
            sort(nums, 0, n - 1);
        }

        private void sort(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return;
            }

            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }

        private void merge(int[] nums, int lo, int mid, int hi) {
            //存入临时数组
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

        public int reversePairs(int[] nums) {
            // 执行归并排序
            sort(nums);
            return count;
        }
    }


}
