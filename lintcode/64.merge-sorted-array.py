class Solution:
    """
    @param A: sorted integer array A which has m elements, 
              but size of A is m+n
    @param B: sorted integer array B which has n elements
    @return: void
    """
    def mergeSortedArray(self, A, m, B, n):
        # write your code here
        i,j=m-1,n-1
        while i>=0 or j>=0:
            if j<0 or (i>=0 and A[i]>=B[j]):
                A[i+j+1]=A[i]
                i-=1
            else:
                A[i+j+1]=B[j]
                j-=1
