class Solution:
    # @param num: a rotated sorted array
    # @return: the minimum number in the array
    def findMin(self, num):
        # write your code here
        low = 0
        high = len(num)-1
        while low<=high:
            if high-low<=1:
                return min(num[high], num[low])
            if num[low]<num[high]:
                return num[low]
            mid = low + (high-low)/2
            if num[mid]>num[low]:
                low = mid + 1
            elif num[mid]<num[low]:
                high = mid
            else:
                low += 1
        return num[mid]
