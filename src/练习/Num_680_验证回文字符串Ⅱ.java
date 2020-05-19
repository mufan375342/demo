package 练习;

/**
 * @author mufan
 * @date 2020/5/19
 */
public class Num_680_验证回文字符串Ⅱ {

    private static Boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return test1(s, left + 1, right) || test1(s, left, right - 1);
            }
        }
        return true;
    }

    public static boolean test1(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
