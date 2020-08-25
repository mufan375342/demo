package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/8/25
 */
public class Num_438_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        // 记录最短子串的开始位置和长度
        int left = 0;
        int right = 0;
        // 记录 window 中已经有多少字符符合要求了
        int match = 0;

        // 相当于两个计数器
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            int count = needs.getOrDefault(p.charAt(i), 0);
            needs.put(p.charAt(i), count + 1);
        }

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).compareTo(needs.get(c1)) == 0)
                    // 字符 c1 的出现次数符合要求了
                    match++;
            }
            //right继续前进找可行解
            right++;

            // window 中的字符串已符合 needs 的要求了
            while (match == needs.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                //开始进行优化，即缩小区间，删除s[left]
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);

                    if (window.get(c2) < needs.get(c2))
                        // 字符 c2 出现次数不再符合要求
                        match--;
                }
                left++;
            }
        }
        return res;
    }
}
