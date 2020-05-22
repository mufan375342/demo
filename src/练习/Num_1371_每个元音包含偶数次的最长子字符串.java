package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/5/21
 */
public class Num_1371_每个元音包含偶数次的最长子字符串 {

    //思路参考链接:https://leetcode.jp/leetcode-1371-find-the-longest-substring-containing-vowels-in-even-counts-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/

    /**
     * 解题思路
     * 1.aeiou 五个元音字母,每个字母都有两种状态.可以用二进制来表示这两种状态。二进制位为1则为奇数，二进制位为0则为偶数
     * 2.比如：11111二进制位都为1的时候表示aeiou出现的次数都是奇数次。11111的十进制表示为31
     * 3.我们可以定义一个长度为32的数组,来记录每种状态的变化.数组的下标即为二进制位对应的值。
     * 4.解决提的根本在于了解异或，异或相同则为0，不同则为1.
     * 5.当某两个状态相同的情况下，那两种状态中间的值一定会是符合条件的字符串
     */
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
