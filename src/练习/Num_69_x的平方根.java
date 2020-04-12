package 练习;

/**
 * @author mufan
 * @date 2020/4/12
 */
public class Num_69_x的平方根 {
    public static int mySqrt(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x / 2 + 1
        long right = x / 2 + 1L;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环,
            // 比如4,left=1,right=1 会一直等于1然后一直循环下去造成死循环
            // 如果取左中位则while循环中可能造成left=right.然后死循环
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public static void main(String[] args) {
        int i = mySqrt(4);
        System.out.println(i);
    }
}
