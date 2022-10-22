package Chapter1.手把手刷图论.KRUSKAL最小生成树算法;

/*
 * @author icyrain11~
 * @version 16
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("All")
public class LeetCode1135 {

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


    int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);

        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        int mst = 0;
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            int weight = connection[2];

            if (uf.connected(u, v)) {
                continue;
            }
            mst += weight;
            uf.union(u, v);
        }

        return uf.count() == 2 ? mst : -1;
    }

}
