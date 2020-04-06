package 练习;

import javafx.util.Pair;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/5
 */
public class Num_127_单词接龙_双向DFS {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
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
        Queue<Pair<String, Integer>> beginQueue = new ArrayDeque<>();
        beginQueue.add(new Pair<>(beginWord, 1));

        Queue<Pair<String, Integer>> endQueue = new ArrayDeque<>();
        endQueue.add(new Pair<>(endWord, 1));

        //剪枝-->访问过的元素无需再次访问,因为是双向DFS,所以需要记录level
        Map<String, Integer> beiginVisited = new HashMap<>();
        beiginVisited.put(beginWord, 1);

        Map<String, Integer> endVisited = new HashMap<>();
        endVisited.put(endWord, 1);

        //DFS求相交点,如果没有相交点则返回0
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            Pair<String, Integer> beginPoll = beginQueue.poll();
            String bWord = beginPoll.getKey();
            Integer bLevel = beginPoll.getValue();
            for (int i = 0; i < beginWord.length(); i++) {
                String newBWord = bWord.substring(0, i) + "*" + bWord.substring(i + 1);
                for (String word : map.getOrDefault(newBWord, new ArrayList<>())) {
                    if (endVisited.containsKey(word)) {
                        return bLevel + endVisited.get(word);
                    }
                    if (!beiginVisited.containsKey(word)) {
                        beiginVisited.put(word, bLevel + 1);
                        beginQueue.add(new Pair<>(word, bLevel + 1));
                    }
                }
            }
            Pair<String, Integer> endPoll = endQueue.poll();
            String eWord = endPoll.getKey();
            Integer endLevel = endPoll.getValue();
            for (int i = 0; i < endWord.length(); i++) {
                String newEWord = eWord.substring(0, i) + "*" + eWord.substring(i + 1);
                for (String word : map.getOrDefault(newEWord, new ArrayList<>())) {
                    if (beiginVisited.containsKey(word)) {
                        return endLevel + beiginVisited.get(word);
                    }
                    if (!endVisited.containsKey(word)) {
                        endVisited.put(word, endLevel + 1);
                        endQueue.add(new Pair<>(word, endLevel + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        Num_127_单词接龙_双向DFS test = new Num_127_单词接龙_双向DFS();
        int i = test.ladderLength("hit", "cog", list);
        System.out.println(i);
    }
}
