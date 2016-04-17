class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :rtype: int
        """
        map = {} 
        maxLen = 0
        start = 0
        for i in range(len(s)):
                if len(map)==k and s[i] not in map:
                        while start<i:
                                map[s[start]]-=1
                                if map[s[start]]==0:
                                        del map[s[start]]
                                        start+=1
                                        break
                                else:
                                        map[s[start]]-=1
                                        start+=1
                if s[i] not in map:
                        map[s[i]]=0
                map[s[i]]+=1
                if i-start+1>maxLen:
                        maxLen=i-start+1
        return maxLen

sol = Solution()
print sol.lengthOfLongestSubstringKDistinct("absddbd", 2)
