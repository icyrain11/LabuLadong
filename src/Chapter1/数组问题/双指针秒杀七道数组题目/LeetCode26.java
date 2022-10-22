package Chapter1.数组问题.双指针秒杀七道数组题目;

/**
 * 删除有序数组中的重复项
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {

        //base case
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
