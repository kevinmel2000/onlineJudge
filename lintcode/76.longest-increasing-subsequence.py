class Solution:
    """
    @param nums: The integer array
    @return: The length of LIS (longest increasing subsequence)
    """
    def longestIncreasingSubsequence(self, nums):
        # write your code here
        n = len(nums)
        dp = [0]*(n+1)
        maxLen = 0
        for i in range(1, n+1):
            for j in range(i):
                if j==0 or nums[i-1]>=nums[j-1]:
                    dp[i] = max(dp[i],dp[j]+1)
                if dp[i]>maxLen:
                    maxLen = dp[i]
        return maxLen
