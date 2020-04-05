package 练习;

/**
 * @author mufan
 * @date 2020/4/4
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Num_22_括号生成_BFS {

    public class Node {
        private int left;
        private int right;
        private String res;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left == 0 && node.right == 0) {
                res.add(node.res);
            }
            if (node.left > 0) {
                queue.add(new Node(node.res + "(", node.left - 1, node.right));
            }
            if (node.right > 0 && node.left < node.right) {
                queue.add(new Node(node.res + ")", node.left, node.right - 1));
            }
        }
        return res;
    }

    // 把结果集保存在动态规划的数组里

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        generateParenthesis(4);
        System.out.println(1234567);
    }
}
