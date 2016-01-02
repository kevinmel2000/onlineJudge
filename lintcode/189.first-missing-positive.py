class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        # write your code here
        #if not A: return 1
        for i in range(len(A)):
            while A[i]<=len(A) and A[i]>=1 and A[A[i]-1]!=A[i]:
                tmp=A[i]-1
                A[i],A[tmp]=A[tmp],A[i]
            
        for i in range(len(A)):
            if A[i]!=i+1: return i+1
        
        return len(A)+1
