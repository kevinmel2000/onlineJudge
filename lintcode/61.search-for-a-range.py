class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be searched
    @return : a list of length 2, [index1, index2]
    """
    def searchRange(self, A, target):
        # write your code here
        if len(A) == 0: return [-1,-1]
        low = 0
        high = len(A)-1
        #if target < A[low] or target > A[high]:
        #    return [-1,-1]
        # find <=
        mid=(high+low+1)/2
        while low < high:
            if A[mid] <= target:
                low = mid
            else: 
                high = mid - 1
            mid=(high+low+1)/2
        if target == A[mid]:
            left = mid
        else:
            return [-1,-1]
        low = 0
        high = len(A)-1
        # find >=
        mid=low+(high-low)/2
        while low < high:
            if A[mid] >= target:
                high = mid
            else:
                low = mid + 1
            mid=low+(high-low)/2
        right = mid
        return [right,left]
