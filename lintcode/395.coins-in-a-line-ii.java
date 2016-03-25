public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n=values.length;
        int sum=0;
        if(n<=2) return true;
        int[] dp = new int[n];
        dp[n-1]=values[n-1];
        dp[n-2]=values[n-2]+values[n-1];
        sum+=values[n-1]+values[n-2];
        for(int i=n-3;i>=0;i--) {
            sum+=values[i];
            int dp4=(i>=n-4)? 0 : dp[i+4];
            int dp3=(i==n-3)? 0 : dp[i+3];
            dp[i]= Math.max(values[i]+Math.min(dp[i+2], dp3), values[i]+values[i+1]+Math.min(dp3, dp4));
        }

        if(dp[0]>sum-dp[0]) return true;
        return false;
    }
}
