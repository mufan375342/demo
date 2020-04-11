package 练习;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/6
 * 如果是简单版的DFS,则每次去查询curWord和wordList只有一位字符不相同的单词,时间复杂度为O(m * n)m是单词的长度,n是wordList长度
 * 如何去达到O(N)的复杂度呢?将单词的每一个字符进行替换(a-z),然后罗列所有可能的转换,然后进行dfs查询
 * 剪枝：无论那一层，只要访问过得单词就无需再次访问,比如在第二层访问abc和第三层访问abc,最短的路径肯定是在第二层而不是第三层
 * 记录每个单词的下一层的全部元素，这里需要做特殊的处理。使用BFS进行查找,
 * 然后如果k层包含的元素已经在k-1层访问过了,那么访问该层的时候就不需要访问该元素了
 * <p>
 * 在单词接龙的基础上，需要将找到的最短路径存储下来；
 * 之前的队列只用来存储每层的元素，那么现在就得存储每层添加元素之后的结果："ab","if",{"cd","af","ib","if"}；
 * （1）第一层：{"ab"}
 * （2）第二层：{"ab","af"}、{"ab","ib"}
 * （3）第三层：{"ab","af","if"}、{"ab","ib","if"}
 * 如果该层添加的某一个单词符合目标单词，则该路径为最短路径，该层为最短路径所在的层，但此时不能直接返回结果，必须将该层遍历完，将该层所有符合的结果都添加进结果集；
 * 每层添加单词的时候，不能直接添加到总的已访问单词集合中，需要每层有一个单独的该层访问的单词集，该层结束之后，再会合到总的已访问单词集合中，原因就是因为3.
 */
public class Num_126_单词接龙2_DFS {


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> distSet = new HashSet<>(wordList);
        // 字典中不包含目标单词
        if (!distSet.contains(endWord)) {
            return res;
        }
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visted = new HashSet<>();

        List<String> list = new ArrayList<>();
        list.add(beginWord);

        queue.add(list);
        visted.add(beginWord);
        // 是否到达符合条件的层：如果该层添加的某一单词符合目标单词，则说明截止该层的所有解为最短路径，停止循环
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            //上一层的队列
            int size = queue.size();
            // 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
            // 如果直接添加到 visited 中，会导致该层本次结果添加之后的相同添加行为失败
            // 如：该层遇到目标单词，有两条路径都可以遇到，但是先到达的将该单词添加进 visited 中，会导致第二条路径无法添加
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                //每次去拿一个路径
                List<String> path = queue.poll();
                assert path != null;
                String word = path.get(path.size() - 1);
                //枚举a-->z,找出可能与word可以连接的单词
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        //将单词的每一个字符进行替换
                        chars[j] = k;
                        //这里注意,如果是相同的就跳过,这里不需要进行还原单词,因为本身就是相同的
                        if (chars[j] == temp) {
                            continue;
                        }
                        String str = String.valueOf(chars);
                        if (!visted.contains(str) && distSet.contains(str)) {
                            //生成一个新的路径并放入队里
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(str);
                            queue.add(pathList);
                            subVisited.add(str);
                            if (str.equals(endWord)) {
                                flag = true;
                                res.add(pathList);
                            }
                        }
                    }
                }
                //本层遍历完之后需要将subVisited放入visited中
                visted.addAll(subVisited);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        Num_126_单词接龙2_DFS test = new Num_126_单词接龙2_DFS();
        test.findLadders("hit", "cog", list);
    }


}
