package Chapter1.手把手刷二叉树.归并排序详解及应用;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode912 {

    public int[] sortArray(int[] nums) {
        Merge.sort(nums);
        return nums;
    }

    class Merge {
        //临时数组
        public static int[] temp;

        public static void sort(int[] nums) {
            //给临时数组分配空间
            temp = new int[nums.length];

            //原地排序
            sort(nums, 0, nums.length - 1);
        }

        private static void sort(int[] nums, int lo, int hi) {
            //单个元素无需排序
            if (lo == hi) {
                return;
            }

            //数组分割
            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }


        private static void merge(int[] nums, int lo, int mid, int hi) {
            //将数组信息存入临时数组中
            for (int i = lo; i <= hi; i++) {
                temp[i] = nums[i];
            }

            //双指针排序
            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    //左边排序完成
                    nums[p] = temp[j++];
                } else if (j == hi + 1) {
                    //右边排序完成
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


