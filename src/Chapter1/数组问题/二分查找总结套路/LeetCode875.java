package Chapter1.数组问题.二分查找总结套路;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode875 {


    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 10000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (fx(piles, mid) <= h) {
                //找到目标值则收缩右边界
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    //x为吃香蕉的速度,hours为在这个速度下吃香蕉所需要的时间
    public int fx(int[] piles, int x) {
        //吃香蕉的时间
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }


}
