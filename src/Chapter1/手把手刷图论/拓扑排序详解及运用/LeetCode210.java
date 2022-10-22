package Chapter1.手把手刷图论.拓扑排序详解及运用;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.*;

@SuppressWarnings("All")
public class LeetCode210 {

    List<Integer> postorder = new ArrayList<>();
    boolean hasCycle = false;
    boolean[] visited, onPath;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        //遍历图
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        //有环则无法进行拓扑排序
        if (hasCycle) {
            return new int[]{};
        }
        //逆后序遍历为拓扑排序的顺序
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    public void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            return;
        }

        //开始访问节点
        visited[s] = true;
        onPath[s] = true;
        for (int v : graph[s]) {
            traverse(graph, v);
        }

        //撤销节点
        postorder.add(s);
        onPath[s] = false;
    }


    //创建图
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        //邻接表的创建
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }

        return graph;
    }

}
