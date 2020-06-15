package 练习;

/**
 * @author mufan
 * @date 2020/6/15
 */
public class Num_14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < res.length() && j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (res.equals("")) {
                return "";
            }
        }
        return res;
    }
}
