package 练习;

import javafx.util.Pair;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_127_单词接龙_BFS {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //连通性对应的单词映射
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = map.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                map.put(newWord, list);
            }
        }

        //定义队列
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(beginWord, 1));

        //剪枝-->访问过的元素无需再次访问
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        //DFS
        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            String word = poll.getKey();
            Integer level = poll.getValue();
            for (int i = 0; i < beginWord.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String s : map.getOrDefault(newWord,new ArrayList<>())) {
                    if (endWord.equals(s)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(s)) {
                        visited.put(s, true);
                        queue.add(new Pair<>(s, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> orDefault = map.getOrDefault(1, new ArrayList<>());
        orDefault.add(2);
        System.out.println(23);

    }


}
