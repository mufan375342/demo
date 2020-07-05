package 每日一题;

/**
 * @author mufan
 * @date 2020/7/5
 */
public class Num_44_通配符的匹配 {
    public boolean isMatch(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        /**
         * 因为字符串的匹配需要从后往前进行看,所以dp的定义为slength+1和plength+1
         * dp[i][j]表示待匹配的前i个字符和匹配模式（p）的前j个字符是否相匹配
         * 如何求解dp[i][j]
         * 如果s[i]==p[j]的情况下dp[i][j]=dp[i-1][j-1]
         * 如果p[j-1]=='?' 说明匹配模式中的最后一个字符是？，可以与i的任意字符进行匹配(可以是n个字符)，所以dp[i][j]=dp[i-1][j-1]
         *
         * 如果p[j-1]=='*' 说明匹配模式中的最后一个字符是*,*代表空或者非空，
         * 如果*看做是空的情况下所以dp[i][j]=dp[i][j-1]
         * 如果*看做是非空的情况下，dp[i][j]=dp[i-1][j]
         *
         * 需要逆推dp方程
         *
         * dp中的i实际上就是字符串中的i-1,因为初始化dp的时候比字符串长度多了一位
         * 多这1个长度的目的有两点
         * 1.特殊情况下的处理
         * 2.加入dp[1]的是第1个字符，对应s中该字符的下标就为0
         */
        boolean[][] dp = new boolean[slength + 1][plength + 1];
        //1.dp[0][0]代表的是空字符串和空模式是否匹配，这肯定是匹配的
        dp[0][0] = true;
        //2.空模式和非空字符串肯定是不匹配的所以dp[i][0]=false,这时候不用处理
        //3.非空模式和空字符串进行匹配，就需要考虑模式中的*的问题了(这里i从1开始因为dp[0][0]已经被初始过了)
        for (int i = 1; i <= plength; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        //填充二维数组
        for (int i = 1; i <= slength; i++) {
            for (int j = 1; j <= plength; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];

                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[slength][plength];


    }
}
