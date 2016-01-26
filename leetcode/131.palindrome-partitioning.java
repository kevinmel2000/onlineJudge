public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> solution = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(s, 0, res, solution);
        return solution;
    }
    
    void dfs(String s, int start, List<String> res, List<List<String>> solution) {
        int n = s.length();
        if(start>=n) {
            solution.add(new ArrayList<String>(res));
            return;
        }
        
        for(int i=start;i<n;i++) {
            String sub = s.substring(start, i+1);
            if(isPalindrome(sub)) {
                res.add(sub);
                dfs(s,i+1, res, solution);
                res.remove(res.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
