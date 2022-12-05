import org.junit.Test;

import java.util.*;

/**
 * @author icyrain11
 * @version 1.8
 */
public class Demo {


    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;


    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //构建图
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            //出现
            hasCycle = true;
        }

        //无需遍历
        if (visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for (int t : graph[s]) {
            traverse(graph, t);
        }

        onPath[s] = false;
    }


}
