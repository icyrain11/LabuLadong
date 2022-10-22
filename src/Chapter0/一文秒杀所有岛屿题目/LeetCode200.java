package Chapter0.一文秒杀所有岛屿题目;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")

public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int res = 0;

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //发现岛屿
                if (grid[i][j] == '1') {
                    res++;
                    //利用染色法将岛屿化为0
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //如果越界了则结束
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        //如果已经被淹没了则返回
        if (grid[i][j] == '0') {
            return;
        }


        //进行染色
        grid[i][j] = '0';
        //淹没其附件的陆地
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
