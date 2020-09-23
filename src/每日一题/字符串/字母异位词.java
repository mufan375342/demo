package 每日一题.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/8/27
 */
public class 字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int match = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Integer count = need.getOrDefault(p.charAt(i), 0);
            need.put(p.charAt(i), count + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    match++;
                }
            }
            right++;

            while (match == need.size()) {
                char c1 = s.charAt(left);
                if (right - left == p.length()) {
                    res.add(left);
                }
                if (window.containsKey(c1)) {
                    window.put(c1, window.get(c1) - 1);
                    if (window.get(c1).compareTo(need.get(c1)) < 0) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
