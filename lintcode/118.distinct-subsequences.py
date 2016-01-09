class Solution: 
    # @param S, T: Two string.
    # @return: Count the number of distinct subsequences
    def numDistinct(self, S, T):
        # write your code here
        ns, nt = len(S),len(T)
        dp = [[0 for j in range(nt+1)] for i in range(ns+1)]
        for i in range(ns+1):
            dp[i][0]=1

        for i in range(1, ns+1):
            for j in range(1, nt+1):
                if S[i-1]==T[j-1]:
                    dp[i][j]=dp[i-1][j-1]
                dp[i][j]+=dp[i-1][j]
        
        return dp[ns][nt]
