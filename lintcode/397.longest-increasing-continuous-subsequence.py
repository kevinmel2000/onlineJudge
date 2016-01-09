class Solution:
    # @param {int[]} A an array of Integer
    # @return {int}  an integer
    def longestIncreasingContinuousSubsequence(self, A):
        # Write your code here
        maxLen = 1 if A else 0
        curLen = 1
        i = 0
        up = False
        for i in range(1, len(A)):
            if A[i]>A[i-1]:
                if up:
                    curLen+=1
                else:
                    up = not up
                    curLen=2
            elif A[i]<A[i-1]:
                if not up:
                    curLen+=1
                else:
                    up = not up
                    curLen=2
            else:
                curLen+=1
            if curLen>maxLen:
                maxLen = curLen
        return maxLen
