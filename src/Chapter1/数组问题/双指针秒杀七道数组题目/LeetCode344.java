package Chapter1.数组问题.双指针秒杀七道数组题目;

/**
 * 反转字符串
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode344 {

    public void reverseString(char[] s) {

        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
