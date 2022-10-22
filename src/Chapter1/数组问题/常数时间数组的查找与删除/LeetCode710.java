package Chapter1.数组问题.常数时间数组的查找与删除;

import java.util.HashMap;
import java.util.Random;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode710 {

    class Solution {
        int size = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        public Solution(int n, int[] blacklist) {
            size = n - blacklist.length;
            for(int item : blacklist){
                map.put(item, -1);
            }
            int last = n - 1;
            for(int item : blacklist){
                if(item >= size){
                    continue;
                }
                while(map.containsKey(last)){
                    last--;
                }
                map.put(item, last);
                last--;
            }
        }

        public int pick() {
            int index = (int)(Math.random()*size);
            return map.getOrDefault(index, index);
            // if(map.containsKey(index)){
            //     return map.get(index);
            // }
            // return index;
        }
    }


}
