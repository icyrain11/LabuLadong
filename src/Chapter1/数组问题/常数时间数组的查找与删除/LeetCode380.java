package Chapter1.数组问题.常数时间数组的查找与删除;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode380 {

    class RandomizedSet {
        //存储元素的值
        List<Integer> nums = new ArrayList<>();
        //记录存储元素对应在nums的索引
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        //随机数
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            valToIndex = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            nums.add(val);
            valToIndex.put(val, nums.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            int index = valToIndex.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            nums.remove(nums.size() - 1);
            valToIndex.put(last, index);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            // 随机获取 nums 中的一个元素
            return nums.get(random.nextInt(nums.size()));
        }
    }


}
