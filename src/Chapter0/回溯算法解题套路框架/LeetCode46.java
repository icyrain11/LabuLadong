package Chapter0.回溯算法解题套路框架;

import java.util.LinkedList;
import java.util.List;

/*
 * @author icyrain11~
 * @version 16
 */
public class LeetCode46 {
    List<List<Integer>> res = new LinkedList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);

        return res;
    }
    //路径记录再track中如果结束则res.add路径
    //结束条件nums中的所有元素都在track中出现

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        //结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        //全排列
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的结果
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            backtrack(nums, track);
            //撤销选择
            track.removeLast();
        }
    }
}
