class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;
    public TrieNode() {
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++) {
            if(!cur.children.containsKey(word.charAt(i))) {
                cur.children.put(word.charAt(i), new TrieNode());
            }
            
            if(i==word.length()-1) {
                cur.children.get(word.charAt(i)).isLeaf = true;    
            }
            cur = cur.children.get(word.charAt(i));
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++) {
            if(cur==null || !cur.children.containsKey(word.charAt(i))) {
                return false;
            }
            cur = cur.children.get(word.charAt(i));
        }
        return cur.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++) {
            if(cur==null || !cur.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            cur = cur.children.get(prefix.charAt(i));
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
