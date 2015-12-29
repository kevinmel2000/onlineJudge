class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be searched
    @return : an integer
    """
    def search(self, A, target):
        # write your code here
        low = 0
        high = len(A)-1
        while low <= high:
            mid = low + (high-low)/2
            if target == A[mid]:
                return mid
            if A[mid] > A[low] :
                if target >= A[low] and target<A[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            elif A[mid] < A[low]:
                if target > A[mid] and target <= A[high]:
                    low = mid + 1
                else:
                    high = mid - 1
            else:
                low += 1
        return -1
