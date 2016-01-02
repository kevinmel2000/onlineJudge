class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        # write your code here
        if not A: return 0
        n = len(A)
        dp = [n-i-1 for i in range(len(A))]
        
        #for i in range(1, len(A)):
        #    dp.append(i+1)
        #    for j in range(i):
        #        if j+A[j]>=i and dp[j]+1<dp[i]:
        #            dp[i]=dp[j]+1
        #            if j+A[j]>=len(A): return dp[i]
        # return dp[len(A)-1]
        
        for i in range(len(A)-2, -1, -1):
            for j in range(i+1, n):
                if i+A[i]<j: break
                if i+A[i]>=j and dp[j]+1<dp[i]:
                    dp[i]=dp[j]+1
        
        return dp[0]
