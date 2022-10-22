package Chapter1.数组问题.双指针秒杀七道数组题目;

/**
 * 两数之和
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1,};
    }
}
