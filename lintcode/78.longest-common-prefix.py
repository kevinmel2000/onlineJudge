class Solution:
    # @param strs: A list of strings
    # @return: The longest common prefix
    def longestCommonPrefix(self, strs):
        # write your code here
        if not strs: return ""
        common = list(strs[0])
        for i in xrange(1, len(strs)):
            for j in xrange(len(common)):
                if j>=len(strs[i]) or strs[i][j]!=common[j]:
                    common = common[:j]
                    break
            if not common: return ""
        return ''.join(common)
