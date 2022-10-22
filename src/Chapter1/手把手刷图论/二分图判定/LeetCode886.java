package Chapter1.手把手刷图论.二分图判定;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.*;

@SuppressWarnings("All")
public class LeetCode886 {

    boolean[] visited;
    boolean[] color;
    boolean ok = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];

        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].add(w);
            // w -> v
            graph[w].add(v);
        }
        return graph;
    }

    public void traverse(List<Integer>[] graph, int start) {
        if (!ok) {
            return;
        }
        visited[start] = true;
        for (int w : graph[start]) {
            if (!visited[w]) {
                color[w] = !color[start];
                traverse(graph, w);
            } else {
                if (color[w] == color[start]) {
                    ok = false;
                }
            }
        }
    }

    public void bfs(List<Integer>[] graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty() && ok) {
            int w = queue.poll();
            for (int v : graph[w]) {
                if (!visited[v]) {
                    visited[v] = true;
                    color[v] = !color[w];
                    queue.add(v);
                } else {
                    if (color[v] == color[w]) {
                        ok = false;
                    }
                }
            }
        }
    }
}
