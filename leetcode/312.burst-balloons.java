public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coins = new int[n+2];
        coins[0]=1;
        coins[n+1]=1;
        for(int i=0;i<n;i++) {
            coins[i+1]=nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        
        for(int k=2;k<n+2;k++) {
            for(int left=0;left<n;left++) {
                int right = left+k;
                if(right<n+2) {
                    for(int mid=left+1;mid<right;mid++) {
                        dp[left][right]=Math.max(dp[left][right], coins[mid]*coins[left]*coins[right]+dp[left][mid]+dp[mid][right]);
                    }
                }
            }
        }
        return dp[0][n+1];
    }
}
