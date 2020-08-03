package 穆帆.trie;

/**
 * @author mufan
 * @date 2020/7/9
 */
public class 恢复空格 {

    class TrieNode {
        TrieNode[] childs;
        boolean isWord;

        public TrieNode() {
            childs = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;  //空白的根节点，设为全局变量更醒目

    public int respace(String[] dictionary, String sentence) {
        root = new TrieNode();
        makeTrie(dictionary);   //创建字典树
        int n = sentence.length();
        int[] dp = new int[n + 1];
        //这里从sentence最后一个字符开始
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = n - i;    //初始默认后面全不匹配
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int c = sentence.charAt(j) - 'a';
                if (node.childs[c] == null) {
                    //例如"abcde",i=1,j=2 可找出长度关系
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j + 1]);
                    break;
                }
                if (node.childs[c].isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                } else {
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j + 1]);
                }
                node = node.childs[c];
            }
        }
        return dp[0];
    }

    public void makeTrie(String[] dictionary) {
        for (String str : dictionary) {
            TrieNode node = root;
            for (int k = 0; k < str.length(); k++) {
                int i = str.charAt(k) - 'a';
                if (node.childs[i] == null) {
                    node.childs[i] = new TrieNode();
                }
                node = node.childs[i];
            }
            node.isWord = true; //单词的结尾
        }
    }


}
