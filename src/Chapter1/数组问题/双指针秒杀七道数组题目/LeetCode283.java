package Chapter1.数组问题.双指针秒杀七道数组题目;

/**
 * 移动零
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode283 {


    //remove element
    public int removeElement(int[] nums, int val) {
        //base case
        if (nums.length <= 0) {
            return 0;
        }

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }
        return slow;
    }

    public void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }


}
