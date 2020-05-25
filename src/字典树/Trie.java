package 字典树;

/**
 * @author mufan
 * @date 2020/5/18
 */
public class Trie {

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public Trie() {
        root = new TrieNode('/');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode trieNode = new TrieNode(c);
                p.children[index] = trieNode;
            }
            p = p.children[index];

        }
        p.isEndingChar = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trieNode.children[index] == null) {
                return false;
            }
            trieNode = trieNode.children[index];
        }
        return trieNode.isEndingChar;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (trieNode.children[index] == null) {
                return false;
            }
            trieNode = trieNode.children[index];
        }
        return trieNode != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true

    }
}

