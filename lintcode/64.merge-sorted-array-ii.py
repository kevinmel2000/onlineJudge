class Solution:
    #@param A and B: sorted integer array A and B.
    #@return: A new sorted integer array
    def mergeSortedArray(self, A, B):
        # write your code here
        from bisect import *
        if len(A)>len(B):
            A,B=B,A
        res = []
        lastB=0
        for i in range(len(A)):
            k=bisect_right(B, A[i])
            res+=B[lastB:k]
            res.append(A[i])
            lastB=k
        res+=B[lastB:]
        return res
