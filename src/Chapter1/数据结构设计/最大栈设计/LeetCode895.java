package Chapter1.数据结构设计.最大栈设计;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.HashMap;
import java.util.Stack;

@SuppressWarnings("All")
public class LeetCode895 {

    class FreqStack {

        //记录栈中最大的频率
        int maxFreq = 0;
        // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
        HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();

        public FreqStack() {

        }

        public void push(int val) {
            //获取值对应的频率
            int freq = valToFreq.getOrDefault(val, 0) + 1;
            //获取的频率加1
            valToFreq.put(val, freq);
            // 修改 FV 表：在 freq 对应的列表加上 val
            freqToVals.putIfAbsent(freq, new Stack<>());
            freqToVals.get(freq).push(val);
            //更新最大值
            maxFreq = Math.max(maxFreq, freq);
        }

        public int pop() {
            //修改FV表弹出maxFreq对应的值
            Stack<Integer> vals = freqToVals.get(maxFreq);
            int v = vals.pop();
            int freq = valToFreq.get(v) - 1;
            valToFreq.put(v, freq);
            // 更新 maxFreq
            if (vals.isEmpty()) {
                // 如果 maxFreq 对应的元素空了
                maxFreq--;
            }
            return v;
        }
    }

}