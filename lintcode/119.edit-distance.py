class Solution: 
    # @param word1 & word2: Two string.
    # @return: The minimum number of steps.
    def minDistance(self, word1, word2):
        # write your code here
        # dp[[0 for j in xrange(len(word2)+1)] for i in xrange(len(word1)+1)]
        m = len(word1)
        n = len(word2)
        
        dp = [[0 for i in xrange(n+1)] for j in xrange(m+1)]
        
        for i in xrange(m+1):
            dp[i][0] = i
        
        for j in xrange(n+1):
            dp[0][j] = j
        for i in range(1,m+1):
            for j in range(1,n+1):
                dp[i][j]=min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+(word1[i-1]!=word2[j-1]))
        
        return dp[m][n]
