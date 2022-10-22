package Chapter0.BFS算法解题套路框架;

import java.util.HashSet;
import java.util.Set;

/*
 * @author icyrain11~
 * @version 16
 */

public class LeetCode752 {

    //    public static int openLock(String[] deadends, String target) {
//        //操作队列
//        Queue<String> queue = new LinkedList<>();
//        queue.offer("0000");
//        Set<String> deads = new HashSet<>();
//        for (String deadend : deadends) {
//            deads.add(deadend);
//        }
//        //防止走回头路进入死循环
//        Set<String> visited = new HashSet<>();
//        visited.add("0000");
//        //操作步数
//        int step = 0;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String cur = queue.poll();
//                //终止条件
//                if (deads.contains(cur)) {
//                    continue;
//                }
//                if (target.equals(cur)) {
//                    return step;
//                }
//
//                //将节点未遍历的相邻节点加入队列中
//                for (int j = 0; j < 4; j++) {
//                    String up = plusOne(cur, j);
//                    if (!visited.contains(up)) {
//                        queue.offer(up);
//                        visited.add(up);
//                    }
//                    String down = minusOne(cur, j);
//                    if (!visited.contains(down)) {
//                        queue.offer(down);
//                        visited.add(down);
//                    }
//                }
//            }
//            step++;
//        }
//        return -1;
//
//    }
    //代码优化双向BFS
    public static int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        //用集合不用队列，快速判定元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            //哈希集合在遍历中不能修改，用temp扩容
            Set<String> temp = new HashSet<>();

            //将q1中所有的点向周围扩散
            for (String cur : q1) {
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                //将一个节点未遍历的相邻节点加入集合
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            //增加步数
            step++;
            //下一伦是q2扩散
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public static String plusOne(String strs, int j) {
        char[] chs = strs.toCharArray();
        if (chs[j] == '9') {
            chs[j] = '0';
        } else {
            chs[j] += 1;
        }

        return new String(chs);
    }

    public static String minusOne(String strs, int j) {
        char[] chs = strs.toCharArray();
        if (chs[j] == '0') {
            chs[j] = '9';
        } else {
            chs[j] -= 1;
        }

        return new String(chs);
    }

}
