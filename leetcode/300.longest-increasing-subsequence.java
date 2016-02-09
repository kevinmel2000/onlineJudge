public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int longest = 1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            if(dp[i]>longest) {
                longest = dp[i];
            }
        }
        return longest;
    }
}
