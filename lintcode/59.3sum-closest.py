class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @param target : An integer
    @return : return the sum of the three integers, the sum closest target.
    """
    def threeSumClosest(self, numbers, target):
        # write your code here
        sortedNum = sorted(numbers)
        n = len(numbers)
        closest = sys.maxsize/3
        for k in range(n-2):
            i,j=k+1,len(numbers)-1
            while i<j:
                local = sortedNum[k]+sortedNum[i]+sortedNum[j]
                if abs(local-target)<abs(closest-target):
                    closest=local

                if local<target:
                    i+=1
                elif local>target:
                    j-=1
                else:
                    return closest
        return closest
