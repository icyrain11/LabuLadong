package Chapter1.手把手刷图论.DJKSTRA算法;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.*;

@SuppressWarnings("All")
public class LeetCode1631 {
    // 方向数组，上下左右的坐标偏移量
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //返回坐标(x,y)的上下左右坐标
    List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        //存储相邻节点
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                //索引越界
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }


    class State {
        // 矩阵中的一个位置
        int x, y;
        // 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
        int effortFromStart;

        State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }


    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }


        //优先队列,effortTo小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.effortFromStart - b.effortFromStart;
        });

        // base case，起点到起点的最小消耗就是 0
        effortTo[0][0] = 0;

        //开始BFS
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curx = curState.x;
            int cury = curState.y;
            int curEfforToStart = curState.effortFromStart;


            //到达终点就提前结束
            if (curx == m - 1 && cury == n - 1) {
                return curEfforToStart;
            }

            if (curEfforToStart > effortTo[curx][cury]) {
                continue;
            }

            for (int[] neighbor : adj(heights, curx, cury)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                //计算从(curX,curY)到(nextX,nextY)的消耗
                int effortToNextNode = Math.max(effortTo[curx][cury], Math.abs(heights[curx][cury] - heights[nextX][nextY]));
                //更新dp
                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
        return -1;
    }


}
