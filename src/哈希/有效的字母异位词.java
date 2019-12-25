package 哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mufan
 * @date 2019/12/25
 */
public class 有效的字母异位词 {

    public static boolean isAnagram1(String a, String b) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            String s = String.valueOf(a.charAt(i));
            if (map.get(s) != null) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            String s = String.valueOf(b.charAt(i));
            if (map1.get(s) != null) {
                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }
        }
        return map.equals(map1);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram1("anagram",
                "nagaram"));
    }
}
