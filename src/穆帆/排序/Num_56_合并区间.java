package 穆帆.排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mufan
 * @date 2020/7/5
 */
public class Num_56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[intervals.length][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (index == 0) {
                res[index++] = interval;
            } else if (res[index - 1][1] < interval[0]) {
                res[index++] = interval;
            } else {
                res[index - 1][1] = Math.max(res[index - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(res,index);
    }
}
