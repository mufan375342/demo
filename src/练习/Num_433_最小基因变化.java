package 练习;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_433_最小基因变化 {
    private Integer minStep = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<>(), 0, start, end, bank);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void dfs(HashSet<String> visited, int step, String current, String end, String[] bank) {
        //termanitor
        if (current.equals(end)) {
            minStep = Math.min(minStep, step);
            return;
        }
        //process
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (current.charAt(i) != str.charAt(i) && diff++ > 1) {
                    break;
                }
            }
            if (diff == 1 && !visited.contains(str)) {
                visited.add(str);
                //drill down
                dfs(visited, step + 1, str, end, bank);
                //reverse the current status
                visited.remove(str);

            }
        }
    }

}
