class Solution:
    #param matrix: a matrix of 0 and 1
    #return: an integer
    def maxSquare(self, matrix):
        # write your code here
        m = len(matrix)
        if m==0: return 0
        n = len(matrix[0])
        dp = [[0]*(n+1) for i in range(m+1)]
        maxs = 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1]==1:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
                    if maxs<dp[i][j]:
                        maxs=dp[i][j]

        return maxs*maxs
