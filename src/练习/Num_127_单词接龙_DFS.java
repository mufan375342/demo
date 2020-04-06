package 练习;

import javafx.util.Pair;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_127_单词接龙_DFS {
    private Integer minStep = Integer.MAX_VALUE;

    /**
     * DFS(超过时间限制)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dfs(new HashSet<>(), 0, beginWord, endWord, wordList);
        return minStep == Integer.MAX_VALUE ? 0 : minStep;
    }

    private void dfs(HashSet<String> visited, int step, String curr, String endWord, List<String> wordList) {
        if (curr.equals(endWord)) {
            minStep = Math.min(minStep, step);
            return;
        }
        for (String word : wordList) {
            int diff = 0;
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != word.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1 && !visited.contains(word)) {
                visited.add(word);
                dfs(visited, step + 1, word, endWord, wordList);
                visited.remove(word);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Num_127_单词接龙_DFS num_127_单词接龙 = new Num_127_单词接龙_DFS();
        num_127_单词接龙.ladderLength("a", "c", list);

    }


}

