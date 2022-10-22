package chapter2.用动态规划玩游戏.加权最短路径;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode787 {

    // 哈希表记录每个点的入度
    // to -> [from, price]
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 将中转站个数转化成边的条数
        k++;
        this.src = src;
        this.dst = dst;

        // 初始化备忘录，全部填一个特殊值
        memo = new int[n][k + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -888);
        }

        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            //算入度边
            if (!indegree.containsKey(to)) {
                indegree.put(to, new LinkedList<int[]>());
            }
            indegree.get(to).add(new int[]{from, price});
        }
        return dp(dst, k);
    }

    public int dp(int s, int k) {
        //src->src
        if (s == src) {
            return 0;
        }

        //步数用完了
        if (k == 0) {
            return -1;
        }

        // 查备忘录，防止冗余计算
        if (memo[s][k] != -888) {
            return memo[s][k];
        }


        // 初始化为最大值，方便等会取最小值
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            // 当 s 有入度节点时，分解为子问题
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的入度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);
                // 跳过无解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 如果还是初始值，说明此节点不可达
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }

}
