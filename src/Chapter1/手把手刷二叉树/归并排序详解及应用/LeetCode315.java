package Chapter1.手把手刷二叉树.归并排序详解及应用;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode315 {

    class Solution {


        private class Pair {
            int val, id;

            Pair(int val, int id) {
                //记录元素的值
                this.val = val;
                //记录元素的id
                this.id = id;
            }
        }

        // 归并排序所用的辅助数组
        private Pair[] temp;
        // 记录每个元素后面比自己小的元素个数
        private int[] count;


        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            temp = new Pair[n];
            count = new int[n];
            Pair[] arr = new Pair[n];

            //记录各个元素
            for (int i = 0; i < nums.length; i++) {
                arr[i] = new Pair(nums[i], i);
            }

            // 执行归并排序，本题结果被记录在 count 数组中
            sort(arr, 0, n - 1);

            List<Integer> res = new LinkedList<>();
            for (int c : count) {
                res.add(c);
            }
            return res;
        }

        public void sort(Pair[] arr, int lo, int hi) {
            if (lo == hi) {
                return;
            }

            int mid = lo + (hi - lo) / 2;

            //归并排序
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            merge(lo, mid, hi, arr);
        }

        public void merge(int lo, int mid, int hi, Pair[] arr) {
            //存入临时数组中
            for (int i = lo; i <= hi; i++) {
                temp[i] = arr[i];
            }

            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    arr[p] = temp[j++];
                } else if (j == hi + 1) {
                    arr[p] = temp[i++];
                    // 更新 count 数组
                    count[arr[p].id] += j - mid - 1;
                } else if (temp[i].val > temp[j].val) {
                    arr[p] = temp[j++];
                } else {
                    arr[p] = temp[i++];
                    count[arr[p].id] += j - mid - 1;
                }
            }
        }
    }


}
