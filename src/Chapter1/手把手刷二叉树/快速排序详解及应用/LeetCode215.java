package Chapter1.手把手刷二叉树.快速排序详解及应用;

import org.junit.Test;

import java.util.Random;


/**
 * @author icyrain11
 * @version 1.8
 */
@SuppressWarnings("All")
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        Quick.sort(nums);
        return nums[nums.length - k - 1];
    }

    class Quick {
        private static void sort(int[] nums) {
            // 为了避免出现耗时的极端情况，先随机打乱
            shuffle(nums);
            // 排序整个数组（原地修改）
            sort(nums, 0, nums.length - 1);
        }

        private static void sort(int[] nums, int lo, int hi) {
            if (lo >= hi) {
                return;
            }
            int p = partition(nums, lo, hi);
            sort(nums, lo, p - 1);
            sort(nums, p + 1, hi);
        }

        private static int partition(int[] nums, int lo, int hi) {
            int pivot = nums[lo];
            int i = lo + 1, j = hi;
            while (i <= j) {
                while (i < hi && nums[i] <= pivot) {
                    i++;
                }
                while (j > lo && nums[j] > pivot) {
                    j--;
                }
                // 此时 [lo, i) <= pivot && (j, hi] > pivot
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
            }
            swap(nums, lo, j);
            return j;
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 洗牌算法，将输入的数组随机打乱
        private static void shuffle(int[] nums) {
            Random rand = new Random();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // 生成 [i, n - 1] 的随机数
                int r = i + rand.nextInt(n - i);
                swap(nums, i, r);
            }
        }

    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Quick.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


}
