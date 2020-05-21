package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/5/21
 */
public class Num_1371_每个元音包含偶数次的最长子字符串 {

    //思路参考链接:https://leetcode.jp/leetcode-1371-find-the-longest-substring-containing-vowels-in-even-counts-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
    public int findTheLongestSubstring(String s) {
        int[] pre = new int[32];
        Arrays.fill(pre, -1);
        pre[0] = 0;
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case 'a':
                    cur ^= 1;
                    break;
                case 'e':
                    cur ^= 2;
                    break;
                case 'i':
                    cur ^= 4;
                    break;
                case 'o':
                    cur ^= 8;
                    break;
                case 'u':
                    cur ^= 16;
                    break;
                default:
                    break;
            }
            if (pre[cur] == -1) {
                pre[cur] = i + 1;
            } else {
                ans = Math.max(ans, i + 1 - pre[cur]);
            }
        }
        return ans;
    }
}
