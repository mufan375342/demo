package 练习.堆栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author mufan
 * @date 2019/12/22
 */
public class 左右括号匹配 {

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (!map.keySet().contains(str)) {
                stack.push(str);
            } else if (stack.empty() || !stack.pop().equals(map.get(str))) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(())()"));
        System.out.println(isValid("(([]))"));
        System.out.println(isValid("([(]))"));
    }
}
