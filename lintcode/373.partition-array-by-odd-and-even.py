class Solution:
    # @param nums: a list of integers
    # @return: nothing
    def partitionArray(self, nums):
        # write your code here
        j=0
        for i in range(len(nums)):
           if nums[i] & 1:
               nums[i],nums[j]=nums[j],nums[i]
               j+=1
