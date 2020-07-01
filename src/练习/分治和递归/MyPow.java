package 练习.分治和递归;

/**
 * @author mufan
 * @date 2020/1/2
 */
public class MyPow {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        }
        return x * myPow(x, n / 2) * myPow(x, n / 2);
    }

    public static double myPow1(double x, int n) {
        //这里转换为long的值,因为如果传入-2147483648,如果要把这个转换为正数,大于int的最大值
        Long a = (long) n;
        if (a < 0) {
            x = 1 / x;
            a = -a;
        }
        double pow = 1;
        while (a > 0) {
            //二进制1010 = 0*2^0 + 1*2^1 + 0*2^2 + 1*2^3
            //a & 1判断的是二进制位是否为1,也可以是奇数和偶数的判断
            if ((a & 1) == 1) {
                pow *= x;
            }
            x *= x;
            a >>= 1;

        }
        return pow;
    }

    public static void main(String[] args) {
        System.out.println(myPow(4, 2));
        System.out.println(myPow1(4, 2));
    }
}
