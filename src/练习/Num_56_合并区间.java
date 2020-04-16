package 练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author mufan
 * @date 2020/4/16
 * 可以一边添加一边比较的形式
 */
public class Num_56_合并区间 {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        if (intervals.length < 2) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        // 到最后的时候intevals的内部值发生了变化,二维数组的值是否添加到数组中,完全决定于后一个元素。
        // 遍历到倒数第二个元素是因为每次比较的时候都是与前一位的元素进行比较所以最后的一个元素必定会进行加入到返回列表中
        list.add(intervals[intervals.length - 1]);
        return list.toArray(new int[list.size()][2]);
    }



    public int[][] merge1(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;

        int cnt = 0; // 合并次数
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null; // 清空前者
                    cnt++;
                    break;
                }
            }
        }

        int[][] res = new int[len - cnt][2]; // len - cnt 合并后个数
        int record = 0;
        for (int[] pair : intervals) {
            if (pair != null) {
                res[record++] = pair;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(arr);
    }
}
