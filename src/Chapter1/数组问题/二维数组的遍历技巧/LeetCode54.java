package Chapter1.数组问题.二维数组的遍历技巧;

import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upBound = 0, lowBound = m - 1;
        int leftBound = 0, rightBound = n - 1;

        List<Integer> res = new LinkedList<>();
        while (res.size() < m * n) {
            //开始遍历
            if (upBound <= lowBound) {
                //在顶部从左向右遍历
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upBound][i]);
                }
                //向下移动
                upBound++;
            }

            if (leftBound <= rightBound) {
                //从上到下
                for (int i = upBound; i <= lowBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            //从右到左
            if (upBound <= lowBound) {
                //从左到右
                for (int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[lowBound][i]);
                }
                lowBound--;
            }

            //从下到上
            if (leftBound <= rightBound) {
                for (int i = lowBound; i >= upBound; i--) {
                    res.add(matrix[i][leftBound]);
                }

                leftBound++;
            }

        }

        return res;
    }


}
