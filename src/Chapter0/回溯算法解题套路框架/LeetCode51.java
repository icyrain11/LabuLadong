package Chapter0.回溯算法解题套路框架;

/*
 * @author icyrain11~
 * @version 16
 */

import javax.sound.midi.Track;
import java.util.*;

//public class LeetCode51 {
//    static List<List<String>> res = new ArrayList<>();
//
//    public static List<List<String>> solveNQueens(int n) {
//        List<String> track = new ArrayList<>();
//
//        //初始化track
//        for (int i = 0; i < n; i++) {
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                sb.append('.');
//            }
//            track.add(sb.toString());
//        }
//        //回溯递归
//        backtrack(track, 0);
//        return res;
//    }
//
//
//    public static void backtrack(List<String> track, int row) {
//        //结束条件
//        if (row == track.size()) {
//            res.add(new LinkedList(res));
//            return;
//        }
//
//        //递归列添加
//        int col = track.size();
//        for (int i = 0; i < col; i++) {
//            if (isValid(track, row, col)) {
//                continue;
//            }
//        }
//    }
//
//
//    //是否有效
//    public boolean isValid(List<String> track, int row, int col) {
//        int n = track.size();
//        //开始检查上下左右是否有效
//        for (int i = 0; i < n; i++) {
//            if (track[i][col] == 'Q') {
//
//            }
//        }
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        solveNQueens(4);
//    }
//}
