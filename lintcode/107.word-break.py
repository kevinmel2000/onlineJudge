class Solution:
    # @param s: A string s
    # @param dict: A dictionary of words dict
    def wordBreak(self, s, dict):
        # write your code here
        if not dict: return len(s)==0
        dp = [False]*(len(s)+1)        
        dp[0] = True
        
        maxLen = max([len(w) for w in dict])
        for i in xrange(1, len(s)+1):
            for j in xrange(i-min(i,maxLen), i):
                if s[j:i] in dict and dp[j]:
                    dp[i]=True
                    break
        
        return dp[len(s)]
