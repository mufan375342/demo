package 练习.字典树;

/**
 * @author mufan
 * @date 2020/5/18
 */
public class TrieNode {

    public char data;

    public TrieNode[] children = new TrieNode[26];

    public boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
