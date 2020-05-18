package 字典树;

/**
 * @author mufan
 * @date 2020/5/18
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode trieNode = new TrieNode(c);
                p.children[index] = trieNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (char c : pattern) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }
}
