class Solution:
    # @param heights: a list of integers
    # @return: a integer
    def trapRainWater(self, heights):
        # write your code here
        if not heights: return 0
        left = [heights[0]]
        for i in range(1, len(heights)-1):
            if heights[i]<left[-1]:
                left.append(left[-1])
            else:
                left.append(heights[i])
        right = heights[-1]
        res = 0
        for i in range(len(heights)-2, 0, -1):
            if heights[i]<min(right,left[i-1]):
                res+=min(right,left[i-1])-heights[i]
            if heights[i]>right:
                right = heights[i]
        return res
