package 练习;

import java.util.LinkedList;

/**
 * @author mufan
 * @date 2020/5/28
 */
public class Num_222_字符串解码 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stackMutil = new LinkedList<>();
        LinkedList<String> stackRes = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stackMutil.addLast(multi);
                stackRes.addLast(res.toString());
                res = new StringBuilder();
                multi = 0;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                Integer curMulti = stackMutil.removeLast();
                for (int i = 0; i < curMulti; i++) {
                    sb.append(res);
                }
                res = new StringBuilder(stackRes.removeLast() + sb);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
