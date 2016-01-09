class Solution:
    # @param A, B: Two string.
    # @return: the length of the longest common substring.
    def longestCommonSubstring(self, A, B):
        # write your code here
        na,nb = len(A),len(B)
        dp = [[0]*(nb+1) for i in range(na+1)]
        
        maxSub = 0
        for i in range(1, na+1):
            for j in range(1, nb+1):
                dp[i][j]=1+dp[i-1][j-1] if A[i-1]==B[j-1] else 0
                if dp[i][j]>maxSub:
                    maxSub=dp[i][j]
        return maxSub
