class Solution:
    """
    @param A: A list of integers
    @param elem: An integer
    @return: The new length after remove
    """
    def removeElement(self, A, elem):
        # write your code here
        j=0
        for i in range(len(A)):
            if A[i]!=elem:
                A[j]=A[i]
                j+=1
        
        return j
