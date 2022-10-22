package Chapter1.手把手刷图论.二分图判定;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("All")
public class LeetCode785 {
    private boolean ok = true;
    boolean[] color;
    boolean[] visited;

    //主函数
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        //图不一定都是联通的因此要把每一个当作头结点进行遍历
        for (int v = 0; v < graph.length; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }

        return ok;
    }

    public void traverse(int[][] graph, int v) {
        //如果已经确定不是二分图那就可以停止遍历了
        if (!ok) {
            return;
        }
        visited[v] = true;
        //遍历附近节点
        for (int w : graph[v]) {
            if (!visited[w]) {
                //相邻节点未访问过那么给相邻节点涂上不同的颜色
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                //如果v和w颜色相同那么则不为二分图
                if (color[w] == color[v]) {
                    ok = false;
                }
            }
        }
    }

    // 从 start 节点开始进行 BFS 遍历
    private void bfs(int[][] graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty() && ok) {
            int v = q.poll();
            // 从节点 v 向所有相邻节点扩散
            for (int w : graph[v]) {
                if (!visited[w]) {
                    // 相邻节点 w 没有被访问过
                    // 那么应该给节点 w 涂上和节点 v 不同的颜色
                    color[w] = !color[v];
                    // 标记 w 节点，并放入队列
                    visited[w] = true;
                    q.offer(w);
                } else {
                    // 相邻节点 w 已经被访问过
                    // 根据 v 和 w 的颜色判断是否是二分图
                    if (color[w] == color[v]) {
                        // 若相同，则此图不是二分图
                        ok = false;
                    }
                }
            }
        }
    }
}
