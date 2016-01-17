class Solution:
    """
    @param A: An integer array.
    @param B: An integer array.
    @return: Cosine similarity.
    """
    def cosineSimilarity(self, A, B):
        # write your code here
        from math import sqrt
        if len(A)!=len(B): return 2.0000
        sumAB,sumA,sumB=0,0,0
        for i in range(len(A)):
            sumAB+=A[i]*B[i]
            sumA+=A[i]*A[i]
            sumB+=B[i]*B[i]
            
        if sumA==0 or sumB==0: return 2.0000
        return sumAB/(sqrt(sumA)*sqrt(sumB))
