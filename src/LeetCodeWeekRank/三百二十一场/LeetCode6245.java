package LeetCodeWeekRank.三百二十一场;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode6245 {

    //mySolution  最开始想到的是前缀和数组
//    public int pivotInteger(int n) {
//        int nums[] = new int[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            nums[i] = nums[i - 1] + i;
//        }
//        for (int i = 1; i <= n; i++) {
//            if (nums[i] == nums[n] - nums[i - 1]) {
//                return i;
//            }
//        }
//        return -1;
//    }


    //大佬解法等差数列 d = 1 a1 = 1 的等差数列 等差数列和公式
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if (i * (i + 1) == (n - i + 1) * (i + n)) {
                return i;
            }
        }
        return -1;
    }
}
