package Chapter1.数组问题.数组遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //定义四个方向
        int uppper_bound = 0;
        int lower_bound = m - 1;
        int left_bound = 0;
        int right_bound = n - 1;

        while (res.size() < m * n) {
            //朝右遍历
            if (uppper_bound <= right_bound) {
                for (int j = left_bound; j <= right_bound; j++) {
                    res.add(matrix[uppper_bound][j]);
                }
                //上边界下移动
                uppper_bound++;
            }
            //朝下移动
            if (left_bound <= right_bound) {
                for (int i = uppper_bound; i <= lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                //右边界减小
                right_bound--;
            }
            //朝左移动
            if (uppper_bound <= lower_bound) {
                for (int j = right_bound; j >= left_bound; j--) {
                    res.add(matrix[lower_bound][j]);
                }
                //下边界减小
                lower_bound--;
            }
            //朝上移动
            if (left_bound <= right_bound) {
                for (int i = lower_bound; i >= uppper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                // 左边界右移
                left_bound++;
            }
        }
        return res;
    }
}
