public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> solutions = new ArrayList<>();
        
        int count=0, openN=0, closeN=0;
        char[] cs = s.toCharArray();
        for(char c: cs) {
            if(c=='(') {
                count++;
            } else if(c==')') {
                count--;
                if(count<0) {
                    closeN++;
                    count=0;
                }
            }
        }
        
        if(count<0){
            return solutions;
        }
        
        openN=count;
        StringBuilder sb = new StringBuilder();
        dfs(cs, 0, 0, openN, closeN, sb, solutions);
        return solutions;
    }
    
    void dfs(char[] s, int start, int diff, int openN, int closeN, StringBuilder resSb, List<String> solutions) {
        int ns = s.length;
        if(diff<0) {
            return;
        }

        if(start>=ns) {
            if(openN==0 && closeN==0) {
                solutions.add(resSb.toString());
            }
            return;
        }
        
        if(s[start]!='(' && s[start]!=')') {
            resSb.append(s[start]);
            dfs(s, start+1, diff, openN, closeN, resSb, solutions);
            resSb.deleteCharAt(resSb.length()-1);
        } else if(s[start]=='(') {
            int i = 1;
            while(start+i<ns && s[start+i]=='(') i++;
            resSb.append(s, start, i);
            dfs(s, start+i, diff+i, openN, closeN, resSb, solutions);
            resSb.delete(resSb.length()-i, resSb.length());
            
            if(openN>0) {
                dfs(s, start+1, diff, openN-1, closeN, resSb, solutions);
            }
        } else {
            int i = 1;
            while(start+i<ns && s[start+i]==')') i++;
            resSb.append(s, start, i);
            dfs(s, start+i, diff-i, openN, closeN, resSb, solutions);
            resSb.delete(resSb.length()-i, resSb.length());
            
            if(closeN>0) {
                dfs(s, start+1, diff, openN, closeN-1, resSb, solutions);
            }
        }
    }
}
