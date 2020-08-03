package 穆帆.trie;



/**
 * @author mufan
 * @date 2020/7/9
 */
public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
