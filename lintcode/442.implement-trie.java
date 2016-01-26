/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {
    }
    boolean isLeaf = false;
    Map<Character, TrieNode> children = new HashMap<>();
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            
            cur = cur.children.get(c);
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++) {
            if(cur.children.get(word.charAt(i))==null) {
                return false;
            }
            cur=cur.children.get(word.charAt(i));
        }
        return cur.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++) {
            if(cur.children.get(prefix.charAt(i))==null) {
                return false;
            }
            cur=cur.children.get(prefix.charAt(i));
        }
        return true;
    }
}
