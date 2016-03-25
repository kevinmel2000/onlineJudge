class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [1]
        p2,p3,p5 = 0,0,0
        for i in range(1, n):
            minVal = min(dp[p2]*2, dp[p3]*3, dp[p5]*5)
            dp.append(minVal)
            if minVal==dp[p2]*2:
                p2+=1
            if minVal==dp[p3]*3:
                p3+=1
            if minVal==dp[p5]*5:
                p5+=1

        return dp[n-1]
