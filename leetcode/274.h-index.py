class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        sortedc = sorted(citations, reverse=True)
        n = len(sortedc)
        if not n: return 0
        low,high=0,n-1
        mid = (high+low+1)/2
        while low<high:
            if sortedc[mid]>=mid+1:
                low=mid
            else:
                high=mid-1
            mid = (high+low+1)/2

        return mid+1 if sortedc[mid]>=mid+1 else 0
