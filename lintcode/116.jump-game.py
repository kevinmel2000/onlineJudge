class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        # write your code here
        if not A: return True
        dp = [True]
        if A[0]==0 and len(A)>1: return False
        for i in range(1, len(A)):
            dp.append(False)
            for j in range(i):
                if dp[j] and j+A[j]>=i:
                    dp[i]=True
        
        return dp[len(A)-1]
