public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n==0) return 0;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=(s.charAt(0)!='0')? 1:0;
        for(int i=2;i<=n;i++) {
            if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<='6')) dp[i]+=dp[i-2];
            if(s.charAt(i-1)>='1' && s.charAt(i-1)<='9') dp[i]+=dp[i-1];
        }
        return dp[n];
    }
}
