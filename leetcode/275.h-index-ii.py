class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        if not n: return 0
        low,high = 0, n-1
        mid = low + (high-low)/2
        while low<high:
            if citations[mid]>=n-mid:
                high=mid
            else:
                low=mid+1
            mid = low+(high-low)/2
        
        return n-mid if citations[mid]>=n-mid else 0
