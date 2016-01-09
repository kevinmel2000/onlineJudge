class Solution:
    """
    @params s1, s2, s3: Three strings as description.
    @return: return True if s3 is formed by the interleaving of
             s1 and s2 or False if not.
    @hint: you can use [[True] * m for i in range (n)] to allocate a n*m matrix.
    """
    def isInterleave(self, s1, s2, s3):
        # write your code here
        ns1,ns2 = len(s1),len(s2)
        if len(s3)!=ns1+ns2: return False
        dp = [[False]*(ns2+1) for i in range(ns1+1)]
        dp[0][0]=True
        for j in range(1, ns2+1):
            dp[0][j]=(s2[j-1]==s3[j-1] and dp[0][j-1])
        
        for i in range(1, ns1+1):
            dp[i][0]=(s1[i-1]==s3[i-1] and dp[i-1][0])
        
        for i in range(1, ns1+1):
            for j in range(1, ns2+1):
                dp[i][j]=((s1[i-1]==s3[i+j-1] and dp[i-1][j]) or (s2[j-1]==s3[i+j-1] and dp[i][j-1]))
        
        return dp[ns1][ns2]
