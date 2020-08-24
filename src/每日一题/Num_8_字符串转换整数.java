package 每日一题;

/**
 * @author mufan
 * @date 2020/8/24
 */
public class Num_8_字符串转换整数 {

    public static int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        int res = 0;
        if (str.equals("") || str.length() <= 0) {
            return res;
        }
        int len = str.length();
        //去除前面的空格
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        //如果空格去除完成之后就判断索引是否到了最后的一个元素
        if (index == len) {
            return 0;
        }
        //判断正负号
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < len) {
            int digit = str.charAt(index) - '0';
            //遇到数字了
            if (digit < 0 || digit > 9) {
                break;
            }
            // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
            // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoi(s));

    }
}
