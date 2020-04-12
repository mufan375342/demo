package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/4/11
 */
public class Num_455_分发饼干 {
    /**
     * @param g 饼干
     * @param s 孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int sNum = 0;
        int j = 0;
        for (int value : g) {
            for (; j < s.length; j++) {
                if (value <= s[j]) {
                    sNum++;
                    j++;
                    break;
                }
            }
        }
        return sNum;
    }
}
