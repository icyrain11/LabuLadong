package LeetCodeWeekRank.三百二十二场;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode6255 {

    boolean visited[];

    public int minScore(int n, int[][] roads) {

        //作者是从1开始那么就是要开n + 1个
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        //构图因为是带权图
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        visited = new boolean[n + 1];
        return dfs(graph, 1);
    }

    public int dfs(List<int[]>[] graph, int cur) {
        int min = Integer.MAX_VALUE;
        visited[cur] = true;
        for (int[] to : graph[cur]) {
            min = Math.min(min, to[1]);
            if (!visited[to[0]]) {
                min = Math.min(min, dfs(graph, to[0]));
            }
        }
        return min;
    }
}
