package Chapter1.手把手刷图论.图论基础;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("All")
public class LeetCode797 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //维护路径过程
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    public void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        //添加节点
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            //达到路径终点
            res.add(new LinkedList<Integer>(path));
            path.removeLast();
            return;
        }

        //递归每一个相邻的节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        //从路径移除节点s
        path.removeLast();
    }


    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
    }

}
