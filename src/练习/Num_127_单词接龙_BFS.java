package 练习;

import javafx.util.Pair;
import 堆栈.ArrayQuene;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_127_单词接龙_BFS {
    /**
     * 单向BFS
     */
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

    /**
     * 双向BFS
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);

        Set<String> beginWordVisited = new HashSet<>();
        beginWordVisited.add(beginWord);

        Set<String> endWordVisited = new HashSet<>();
        endWordVisited.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int length = beginWord.length();

        int step = 1;

        while (!beginWordVisited.isEmpty() && !endWordVisited.isEmpty()) {
            if (beginWordVisited.size() > endWordVisited.size()) {
                Set<String> temp = beginWordVisited;
                beginWordVisited = endWordVisited;
                endWordVisited = temp;
            }
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginWordVisited) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < length; i++) {
                    char org = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (chars[i] == j) {
                            continue;
                        }
                        chars[i] = j;
                        String newWord = String.valueOf(chars);
                        if (wordSet.contains(newWord)) {
                            if (endWordVisited.contains(newWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(newWord)) {
                                nextLevelVisited.add(newWord);
                                visited.add(newWord);
                            }
                        }
                    }
                    chars[i] = org;
                }
            }
            beginWordVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }
}
