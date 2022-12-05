package Chapter1.手把手刷图论.拓扑排序详解及运用;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("All")
public class LeetCode207 {


    boolean[] visited;
    boolean[] onPath;

    boolean hasCycle = false;


    //DFS版本
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
//        visited = new boolean[numCourses];
//        onPath = new boolean[numCourses];
//
//        //遍历图中的所有节点
//        for (int i = 0; i < numCourses; i++) {
//            traverse(graph, i);
//        }
//
//        return !hasCycle;
//    }
//
//    public void traverse(List<Integer>[] graph, int s) {
//
//        if (onPath[s]) {
//            hasCycle = true;
//        }
//
//        if (visited[s] || hasCycle) {
//            return;
//        }
//
//        //开始访问
//        visited[s] = true;
//        onPath[s] = true;
//        for (int v : graph[s]) {
//            traverse(graph, v);
//        }
//
//        //后序遍历撤销选择
//        onPath[s] = false;
//    }


    //BFS版本遍历拓扑图
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            //节点的入读 + 1
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                //入度为0 可以作为起点
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            //弹出节点
            int cur = q.poll();
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return count == numCourses;
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
