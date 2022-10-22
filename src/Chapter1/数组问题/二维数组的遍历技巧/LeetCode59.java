package Chapter1.数组问题.二维数组的遍历技巧;

/**
 * 螺旋矩阵 II
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int upBound = 0, lowBound = n - 1;
        int leftBound = 0, rightBound = n - 1;
        //需要填入矩阵的数据
        int num = 1;


        while (num < n * n) {

            //从做到右
            if (upBound <= lowBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    matrix[upBound][i] = num++;
                }
                //上边界下移
                upBound++;
            }

            //从上到下
            if (leftBound <= rightBound) {
                for (int i = upBound; i <= lowBound; i++) {
                    matrix[rightBound][i] = num++;
                }
                rightBound--;
            }

            //从右到左
            if (upBound <= lowBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    matrix[lowBound][i] = num++;
                }
                rightBound--;
            }

            //从下到上移动
            if (leftBound <= rightBound) {
                for (int i = lowBound; i >= upBound; i--) {
                    matrix[i][leftBound] = num++;
                }
                lowBound--;
            }
        }

        return matrix;
    }


}
