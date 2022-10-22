package Chapter0.一文秒杀所有岛屿题目;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
public class LeetCode1020 {

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //先将周围的进行淹没
        for (int i = 0; i < m; i++) {
            //上边进行淹没
            dfs(grid, i, 0);
            //下边进行淹没
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            //左边
            dfs(grid, 0, j);
            //右边
            dfs(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
