package 每日一题;

import java.util.Stack;

/**
 * @author mufan
 * @date 2020/7/4
 */
public class Num_32_最长有效括号 {

    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        //为什么要push -1?因为如果是遇到右括号的时候先将栈顶的元素下标弹出,这时候说明栈顶的元素和右括号已经匹配上了,然后用i减去下一位元素的值计算最大的长度
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                //程序能走到这里说明是右括号.但是这时候栈为空了,所以,需要入栈,这一步的意思是前面的最长长度已经算好了，如果有新的长度更长只能从该下标开始计算了
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }


    public int longestValidParentheses1(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 > 0) ? dp[i - 2] + 2 : 2;
                } else if ((i - dp[i - 1]) > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2) > 0 ? dp[i - dp[i - 1] - 2] : 0;
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
