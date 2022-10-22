package Chapter1.数组问题.二维数组的遍历技巧;

public class LeetCode48 {


    //顺时针遍历
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //沿着对角线镜像镜像对称
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //swap(matrix[i][j] , matrix[j][i])
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //将每一行进行reverse
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    //逆时针遍历
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 沿左下到右上的对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                // swap(matrix[i][j], matrix[n-j-1][n-i-1])
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    public void reverse(int[] row) {
        int i = 0, j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }


}