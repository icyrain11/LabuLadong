package Chapter1.数组问题.差分数组;

/**
 * @author icyrain11
 * @version 1.8
 */

/**
 * 要会员这题
 */

@SuppressWarnings("All")
public class LeetCode370 {


    class Difference {
        //差分数组
        private int[] diff;

        /* 输入一个初始数组，区间操作将在这个数组上进行 */
        public Difference(int[] nums) {
            if (nums.length > 0) {
                diff = new int[nums.length];
                // 根据初始数组构造差分数组
                diff[0] = nums[0];
                for (int i = 1; i < diff.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }
        }

        /* 给闭区间 [i,j] 增加 val（可以是负数）*/
        /*这里的理解就是diff数组就是公差数组diff[i]+=val就是公差=val
        对diff[i]+=3就是对i...之后的元素+3,然后对diff[j]元素-=3那么就是对[j]..之后的元素-=3那么综合之后就可以认为对[i,j]之间的元素+=3* */
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }


        //    int[] res = new int[diff.length];
        //    // 根据差分数组构造结果数组
        //    res[0] = diff[0];
        //    for (int i = 1; i < diff.length; i++){
        //        res[i] = res[i - 1] + diff[i];
        //    }

        /* 返回结果数组 */
        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

    int[] getModifiedArray(int length, int[][] updates) {
        //nums初始化全为0
        int[] nums = new int[length];
        //构造差分法
        Difference df = new Difference(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }

        return df.result();
    }


}
