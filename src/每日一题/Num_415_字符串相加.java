package 每日一题;

/**
 * @author mufan
 * @date 2020/8/3
 */
public class Num_415_字符串相加 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = a + b + carry;
            carry = temp / 10;
            sb.append(temp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
