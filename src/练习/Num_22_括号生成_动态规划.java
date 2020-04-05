package 练习;

/**
 * @author mufan
 * @date 2020/4/4
 */

import java.util.ArrayList;
import java.util.List;

public class Num_22_括号生成_动态规划 {
    /**
     * 动态规划
     * dp(n) = "(" + dp(n-1) + ")" + 右括号在中间的状态
     * 注意:最后一对扩号加入肯定是以左括号开头,但是右括号放的位置就不一定了,右括号可以放中间,也可以放最后。
     * 然后计算的时候必须记录1-n括号可以生成的有效个数,相当于当计算2对括号的时候就相当于"(" + 1对括号的所有的组合 + ")"
     * 上面的公式无法写出表达式,所以需要进行一个变量的抽取
     * dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
     * dp(i) = "(" + dp(j) + ")"  + dp(i-j-1)
     * j的取值范围是0--->(i-1)
     * i-j-1的取值范围为(i-1)-->0
     * i必须是从1到n开始计算
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> should = dp.get(j);
                List<String> surplus = dp.get(i - j - 1);
                for (String str1 : should) {
                    for (String str2 : surplus) {
                        current.add("(" + str1 + ")" + str2);
                    }
                }
            }
            dp.add(current);
        }
        return dp.get(n);
    }
}
