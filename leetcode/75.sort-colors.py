class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = 0
        low = 0
        high = len(nums)-1
        while i<=high:
            if nums[i]==0:
               nums[i],nums[low]=nums[low],nums[i]
               low+=1
               i+=1
            elif nums[i]==1:
                i+=1
            else:
                nums[i],nums[high]=nums[high],nums[i]
                high-=1
