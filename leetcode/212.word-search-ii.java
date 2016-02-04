public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildDict(words);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board, i,j, root, res);        
            }
        }
        return res;
    }
    
    void dfs(char[][] board, int i, int j, TrieNode curN, List<String> res) {
        int m = board.length;
        int n = board[0].length;
        if(curN.s!=null) {
            res.add(curN.s);
            curN.s=null;
        }
        
        if(i>=m || j>=n || i<0 || j<0) return;
        char c = board[i][j];
        if(c=='#' || curN.children[c-'a']==null) {
            return;
        }
        curN = curN.children[c-'a'];
        board[i][j]='#';
        dfs(board, i+1, j, curN, res);
        dfs(board, i, j+1, curN, res);
        dfs(board, i-1, j, curN, res);
        dfs(board, i, j-1, curN, res);
        board[i][j]=c;
    }
    
    TrieNode buildDict(String[] words) {
        TrieNode root = new TrieNode();
        for(String s : words) {
            char[] ca = s.toCharArray();
            TrieNode p = root;
            for(int i=0;i<ca.length;i++) {
                if(p.children[ca[i]-'a']==null) {
                    p.children[ca[i]-'a']=new TrieNode();
                }
                p = p.children[ca[i]-'a'];
            }
            p.s=s;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String s;
    }
}
