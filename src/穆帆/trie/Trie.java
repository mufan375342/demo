package 穆帆.trie;


/**
 * @author mufan
 * @date 2020/7/9
 */
public class Trie {
    private TrieNode root;

    public Trie(char data) {
        root = new TrieNode('/');
    }

    public void insert(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trieNode.children[index] == null) {
                trieNode.children[index] = new TrieNode(c);
            }
            trieNode = trieNode.children[index];
        }
        trieNode.isEndingChar = true;
    }

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

    public boolean startsWith(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trieNode.children[index] == null) {
                return false;
            }
            trieNode = trieNode.children[index];
        }
        return trieNode != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie('/');

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true

    }
}
