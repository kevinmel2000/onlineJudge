class Solution:
    # @param nums: a list of integers
    # @return: an integer
    def findMissing(self, nums):
        # write your code here
        n = len(nums)
        for i in range(n):
            while nums[i]<n and nums[i]>=0 and nums[nums[i]]!=nums[i]:
                tmp = nums[i]
                nums[i]=nums[tmp]
                nums[tmp]=tmp
            
        for i in range(n):
            if nums[i]!=i: return i
        
        return n
