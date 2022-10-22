package Chapter1.手把手刷图论.KRUSKAL最小生成树算法;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("All")
public class LeetCode1584 {


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

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        //生成所有边以及权重
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                //计算两点之间的距离
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }

        //按照权重进行排序
        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        int mst = 0;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (uf.connected(u, v)) {
                continue;
            }

            mst += edge[2];
            uf.union(u, v);
        }
        return uf.count() == 1 ? mst : -1;
    }
}
