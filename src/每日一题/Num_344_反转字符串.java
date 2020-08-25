package 每日一题;

/**
 * @author mufan
 * @date 2020/8/24
 */
public class Num_344_反转字符串 {

    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
