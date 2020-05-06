package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/5/4
 */
public class Num_621_任务调度器 {

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char task : tasks) {
            arr[task - 'A']++;
        }
        Arrays.sort(arr);
        int maxVal = arr[25] - 1;
        int idleTime = maxVal * n;
        for (int i = 24; i >= 0 && arr[i] > 0; i--) {
            idleTime -= Math.min(maxVal, arr[i]);
        }
        return idleTime > 0 ? idleTime + tasks.length : tasks.length;
    }
}
