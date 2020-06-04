package 练习;

/**
 * @author mufan
 * @date 2020/6/2
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 输入: n = 3
 * 输出: 6
 */
public class Num_面试题64 {
    int res = 0;

    /**
     * 平均计算
     */
    public int sumNums1(int n) {
        return (n + 1) * n / 2;
    }

    /**
     * 迭代
     */
    public int sumNums2(int n) {
        for (int i = 1; i <= n; i++)
            res += i;
        return res;
    }

    /**
     * 递归
     */
    public int sumNums3(int n) {
        if (n == 1) {
            return 1;
        }
        n += sumNums3(n - 1);
        return n;
    }

    /**
     * 因为题目有规定条件,所以就需要相办法将递归的if条件去除,这里利用&&的短路来构造递归的终止条件
     * sumNums(n - 1) > 0 这里只是为了构造java的语法
     * x本身也没什么作用,也是为了满足java的预发
     */
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public static double test(int N, int K, int W) {
        int startGet = 1;
        int record = 0;
        for (int i = startGet; i < W; i++) {
            int start = 0;
            start = i + start;
            if (start < K && K <= N) {
                record++;
                continue;
            }
            break;
        }
        return record / (double) W;
    }

    public static void main(String[] args) {
        int N = 10, K = 1, W = 10;
        System.out.println(test(N, K, W));
    }
}
