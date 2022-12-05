package LeetCodeWeekRank.三百二十二场;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode6254 {
    public long dividePlayers(int[] skill) {
        long sum = 0;
        //组数
        long groupNum = (skill.length) / 2;
        for (int i = 0; i < skill.length; i++) {
            sum += skill[i];
        }

        if (sum % groupNum != 0) {
            return -1;
        }

        //需要求的平均数
        long average = sum / groupNum;

        int[] choosed = new int[skill.length];
        Arrays.sort(skill);
        long res = 0;
        int count = 0;

        int i = 0;
        int j = skill.length - 1;

        while (i <= j) {
            if (choosed[i] != 0 || choosed[j] != 0) {
                continue;
            }
            if (skill[i] + skill[j] > average) {
                j--;
            } else if (skill[i] + skill[j] < average) {
                i++;
            } else {
                res += skill[i] * skill[j];
                choosed[i] = 1;
                choosed[j] = 1;
                count++;
                i++;
                j--;
            }
        }

        if (res != 0 && count == groupNum) {
            return res;
        }

        return -1;
    }

    @Test
    public void test() {
        int[] skill = {2, 1, 5, 2};

        System.out.println("dividePlayers(skill) = " + dividePlayers(skill));
    }

}
