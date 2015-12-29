class Solution:
    """
    @param s: A string 
    @param p: A string includes "." and "*"
    @return: A boolean
    """
    def isMatch(self, s, p):
        # write your code here
        dp = [[False for i in range(len(p)+1)] for j in range(len(s)+1)]
        
        dp[0][0]=True
        # implicit: dp[0...][0]=False
        for i in range(len(s)+1):
            for j in range(1, len(p)+1):
                if p[j-1]!='*':
                    dp[i][j]= i==0 if False else (p[j-1]==s[i-1] or p[j-1]=='.') and dp[i-1][j-1]
                else:
                    ii=i;
                    dp[i][j]=dp[i][j-2]
                    while ii==i or (ii>=1 and (p[j-2]==s[ii-1] or p[j-2]=='.')):
                        if dp[ii-1][j-2]:
                            dp[i][j]=True
                            break
                        ii-=1
        return dp[len(s)][len(p)]
