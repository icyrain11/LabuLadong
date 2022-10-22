package Chapter1.手把手刷图论.KRUSKAL最小生成树算法;

/*
 * @author icyrain11~
 * @version 16
 */

//给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
//
//        示例 1：
//
//        输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
//        输出: true
//        示例 2:
//
//        输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//        输出: false
//


import org.junit.Test;

public class LeetCode261 {
    class UF {
        int count;
        int[] parent;
        int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            //初始化父节点
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int count() {
            return count;
        }
    }

    public boolean ValidTree(int n, int[][] edges) {
        UF uf = new UF(n);
        //遍历两个节点并进行相连
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            //如果相连则以及存在环
            if (uf.connected(u, v)) {
                return false;
            }
            //如果不相连则连接
            uf.union(u, v);
        }
        return uf.count() == 1;
    }

}
