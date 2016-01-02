class Solution:
    # @param {int} n a number
    # @return {int[]} Gray code
    def grayCode(self, n):
        # Write your code here
        res=[0]
        for i in range(n):
            res+=[(1<<i)+x for x in reversed(res)]

        return res
