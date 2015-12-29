class Solution:
    """
    @param A: a list of integers
    @return an integer
    """
    def removeDuplicates(self, A):
        # write your code here
        j=0
        for i in range(1, len(A)):
            if A[i]!=A[i-1]:
                j+=1
                A[j]=A[i]
        
        return j+1
