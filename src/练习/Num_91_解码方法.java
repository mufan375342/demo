package 练习;

import java.util.Arrays;

/**
 * @author mufan
 * @date 2020/5/4
 */
public class Num_91_解码方法 {

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        //第一个元素的dp在第一个位置存放
        for (int i = 2; i <= chars.length; i++) {
            if (chars[i - 1] == '0') {
                //因为如果是0,则后面的两个必须是一个组合的状态,所以这时候不用考虑后面两个数的状态,因为后面两个数的状态是固定的,所以dp[i] = dp[i - 2]
                if (chars[i - 2] == '1' || chars[i - 2] == '2') {
                    dp[i] = dp[i - 2];
                }
            } else {
                //后两个数组合则组成的次数是dp[i-2],后两个数不组合组成的个数是dp[i-1]
                if (chars[i - 2] == '1' || (chars[i - 2] == '2' && chars[i - 1] <= '6')) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[chars.length];
    }

    public static void main(String[] args) {
        int [] arr={2,4,5,1};

        Arrays.sort(arr);
        System.out.println(123);
    }
}
