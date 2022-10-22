package Chapter1.数组问题.二维数组的遍历技巧;

import org.junit.Test;

/**
 * 反转字符串中的单词
 */
public class LeetCode151 {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        //再次赋值
        s = sb.toString();
        int i = 0, j = 0;
        while (i < j && j < s.length()) {

        }

        System.out.println(sb.toString());
        return null;
    }


}