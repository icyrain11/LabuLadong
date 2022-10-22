package Chapter1.数组问题.双指针秒杀七道数组题目;

/**
 * 移除元素
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {

        //base case
        if (nums.length <= 0) {
            return 0;
        }

        int slow = 0, fast = 0;

        while (fast < nums.length) {
            //如果相同
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow ;
    }
}
