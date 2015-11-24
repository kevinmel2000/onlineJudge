class Solution:
    """
    @param nums: A list of integers.
    @return: The maximum number inside the window at each moving.
    """
    def maxSlidingWindow(self, nums, k):
        # write your code here
        dq = []
        res = []
        for i in range(len(nums)):
            while dq and i-dq[0]>=k:
                dq.pop(0)
            while dq and (nums[dq[-1]]<nums[i] or i-dq[-1]>=k):
                dq.pop()
            dq.append(i)
            if i>=k-1:
                res.append(nums[dq[0]])
        return res

