public class Solution {
    public String reverseWords(char[] s) {
        int n = s.length;
        char[] res = s;
        reverse(res, 0, n-1);
        int start = 0;
        for(int i=0;i<n;i++) {
            if(i!=0 && res[i]==' ' && res[i-1]!=' ') {
                reverse(res, start, i-1);
            } 
            
            if(res[i]==' ') {
                start=i+1;
            }
        }
        
        if(start!=n) {
            reverse(res, start, n-1);
        }
        return new String(res);
    }
    
    void reverse(char[] s, int i, int j) {
        while(i<j) {
            char c = s[i];
            s[i]=s[j];
            s[j]=c;
            i++;j--;
        }
    }
}
