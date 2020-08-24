package 每日一题;

/**
 * @author mufan
 * @date 2020/8/24
 */
public class Num_459_重复的子字符串 {

    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static boolean repeatedSubstringPattern1(String s) {
        int length = s.length();
        for (int i = 1; i * 2 <= length; i++) {
            if (length % i == 0) {
                boolean match = true;
                for (int j = i; j < length; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abcabcabc"));
    }
}
