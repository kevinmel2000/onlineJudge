public class Solution {
    public int numWays(int n, int k) {
        if(n==0) return 0;
        if(n==1) return k;
        int dp1 = k; // same 
        int dp2 = k*(k-1); // diff
        
        for(int i=2;i<n;i++) {
            int tmp = dp1;
            dp1 = dp2;
            dp2 = (k-1)*(tmp+dp2);
        }
        
        return dp1+dp2;
    }
}
