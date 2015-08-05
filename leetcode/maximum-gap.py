class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maximumGap(self, nums):
        if len(nums)<2:
            return 0
        nums=self.radixSort(nums)
        gap=0;
        for i in range(1, len(nums)):
            gap=max(nums[i]-nums[i-1], gap)
        return gap
        
    def radixSort(self, nums):
        for i in range(31):
            onebucket=[]
            zerobucket=[]
            needle=1<<i
            for e in range(len(nums)):
                if nums[e] & needle !=0:
                    onebucket.append(nums[e])
                else:
                    zerobucket.append(nums[e])
            nums=[]
            nums+=zerobucket
            nums+=onebucket
        return nums
