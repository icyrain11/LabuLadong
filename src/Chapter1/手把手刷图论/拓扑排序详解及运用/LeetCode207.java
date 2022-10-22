package Chapter1.手把手刷图论.拓扑排序详解及运用;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("All")
public class LeetCode207 {


    boolean[] visited;
    boolean[] onPath;

    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //遍历图中的所有节点
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int s) {

        if (onPath[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }

        //开始访问
        visited[s] = true;
        onPath[s] = true;
        for (int v : graph[s]) {
            traverse(graph, v);
        }

        //后序遍历撤销选择
        onPath[s] = false;
    }

    //建图函数
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        //图中一共有numCourse个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            //一条边从from指向to
            graph[from].add(to);
        }

        return graph;
    }


}
