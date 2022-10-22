package Chapter1.手把手刷图论.UnionFind算法;

/*
 * @author icyrain11~
 * @version 16
 */

//题目:
//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
//
//        Example 1:
//
//        0          3
//
//        |          |
//
//        1 --- 2    4
//
//        Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
//
//        Example 2:
//
//        0           4
//
//        |           |
//
//        1 --- 2 --- 3
//
//        Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
@SuppressWarnings("All")
public class LeetCode323 {
    class UF {
        private int count;
        private int[] parent;
        //数组记录树的重量
        private int[] size;

        public UF(int n) {
            this.count = 0;
            parent = new int[n];
            //开始的重量都为1
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void unin(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootQ == rootP) {
                return;
            }
            //小树接到大树下面
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        /* 返回某个节点 x 的根节点 */
        public int find(int x) {
            while (parent[x] != x) {
                //递归寻找父节点的上一节点
                parent[x] = parent[parent[x]];

            }
            return x;
        }


    }

}