package 练习;

import javafx.util.Pair;
import 堆栈.ArrayQuene;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_127_单词接龙_BFS {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int wordLen = beginWord.length();

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordCharArray = word.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char org = wordCharArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (org == k) {
                            continue;
                        }
                        wordCharArray[j] = k;
                        String newWord = String.valueOf(wordCharArray);
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(newWord)) {
                                queue.add(newWord);
                                visited.add(newWord);
                            }
                        }
                    }
                    wordCharArray[j] = org;
                }
            }
            step++;
        }
        return 0;
    }

}
