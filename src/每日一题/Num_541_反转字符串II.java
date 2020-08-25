package 每日一题;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author mufan
 * @date 2020/8/24
 */
public class Num_541_反转字符串II {
    public String reverseStr(String s, int k) {
        String[] split = s.trim().split(" +");
        Collections.reverse(Arrays.asList(split));
        return String.join(" ", split);
    }
}
