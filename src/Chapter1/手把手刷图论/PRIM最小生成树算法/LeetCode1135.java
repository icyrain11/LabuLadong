package Chapter1.手把手刷图论.PRIM最小生成树算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")

//想象一下你是个城市基建规划者，地图上有 N 座城市，它们按以 1 到 N 的次序编号。
//
//        给你一些可连接的选项 conections，其中每个选项 conections[i] = [city1, city2, cost] 表示将城市 city1 和城市 city2 连接所要的成本。（连接是双向的，也就是说城市 city1 和城市 city2 相连也同样意味着城市 city2 和城市 city1 相连）。
//
//        返回使得每对城市间都存在将它们连接在一起的连通路径（可能长度为 1 的）最小成本。该最小成本应该是所用全部连接代价的综合。如果根据已知条件无法完成该项任务，则请你返回 -1。
//
//        示例 1：
//
//        输入：N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
//        输出：6
//        解释：
//        选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
//        示例 2：
//
//        输入：N = 4, conections = [[1,2,3],[3,4,4]]
//        输出：-1
//        解释：
//        即使连通所有的边，也无法连接所有城市。
//        提示：
//        1 <= N <= 10000
//        1 <= conections.length <= 10000
//        1 <= conections[i][0], conections[i][1] <= N
//        0 <= conections[i][2] <= 10^5
//        conections[i][0] != conections[i][1]

public class LeetCode1135 {
    int minimumCost(int n, int[][] connections) {
        //转化成无向图邻接表的形式
        List<int[]>[] graph = buildGraph(n, connections);
        //转换成Prim算法
        Prim prim = new Prim(graph);
        if (!prim.allConnected()) {
            return -1;
        }

        return prim.weightSum();
    }

    List<int[]>[] buildGraph(int n, int[][] connections) {
        //图中有n个节点
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] conn : connections) {
            //题目给的节点从1开始
            //实现prim法则从0开始
            int u = conn[0] - 1;
            int v = conn[1] - 1;
            int weight = conn[2];

            //无向图那么要双向构建
            //定义为int []{from, to,weight}
            graph[u].add(new int[]{u, v, weight});
            graph[v].add(new int[]{v, u, weight});
        }
        return graph;
    }

    class Prim {
        //优先队列
        private PriorityQueue<int[]> pq;
        //类似visited数组的作用,记录哪些节点成为最小生成树的部分
        private boolean[] inMST;
        //记录最小生成树的权重和
        private int weightSum = 0;

        // graph 是用邻接表表示的一幅图，
        // graph[s] 记录节点 s 所有相邻的边，
        // 三元组 int[]{from, to, weight} 表示一条边
        public List<int[]>[] graph;


        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            //按照权重排序
            this.pq = new PriorityQueue<>((a, b) -> {
                return a[2] - b[2];
            });

            int n = graph.length;
            this.inMST = new boolean[n];

            // 随便从一个点开始切分都可以，我们不妨从节点 0 开始
            inMST[0] = true;
            cut(0);

            //不断进行切分,向最小生成树添加边
            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                int to = edge[1];
                int weight = edge[2];
                if (inMST[to]) {
                    //节点pq以及在最小生成树中,跳过
                    //否则会产生环
                    continue;
                }
                //将edge加入最小生成树
                weightSum += weight;
                inMST[to] = true;
                cut(to);
            }

        }

        public void cut(int index) {
            //遍历s的邻边
            for (int[] edge : graph[index]) {
                int to = edge[1];
                if (inMST[to]) {
                    continue;
                }
                pq.offer(edge);
            }
        }

        //返回最小生成树的权重和
        public int weightSum() {
            return this.weightSum;
        }

        //判断最小生成树是否包含所有节点
        public boolean allConnected() {
            for (int i = 0; i < inMST.length; i++) {
                if (!inMST[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void Test() {
        int N = 4;
        int[][] connections = {{1, 2, 3}, {3, 4, 4}};
        System.out.println("minimumCost(N,connections) = " + minimumCost(N, connections));
    }

}
