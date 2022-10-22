package Chapter1.数组问题.数组遍历;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先沿着对角线活着矩阵的镜像
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //反转数组中的每一行
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }

    }

    //反转一维数组
    public void reverse(int[] arr) {
        int i = 0, j = arr.length;
        while (j > i) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
