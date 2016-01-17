class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        if not nums: return
        self.idxSum = []
        self.idxSum.append(nums[0]) 
        for i in xrange(1, len(nums)):
            self.idxSum.append(nums[i]+self.idxSum[i-1]) 

    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        if i:
            return self.idxSum[j]-self.idxSum[i-1]
        else:
            return self.idxSum[j]

# Your NumArray object will be instantiated and called as such:
# numArray = NumArray(nums)
# numArray.sumRange(0, 1)
# numArray.sumRange(1, 2)
