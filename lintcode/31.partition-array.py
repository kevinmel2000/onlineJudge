class Solution:
    """
    @param nums: The integer array you should partition
    @param k: As description
    @return: The index after partition
    """
    def partitionArray(self, nums, k):
        # write your code here
        # you should partition the nums by k
        # and return the partition index as description
        j = 0
        for i in range(len(nums)):
            if nums[i]<k:
                nums[j], nums[i]=nums[i], nums[j]
                j+=1
        return j
