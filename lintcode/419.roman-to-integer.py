class Solution:
    # @param {string} s Roman representation
    # @return {int} an integer
    def romanToInt(self, s):
        # Write your code here
        dict = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100,'D':500,'M':1000}
        res = dict[s[0]]
        for i in range(1, len(s)):
            if dict[s[i-1]]<dict[s[i]]:
                res-=2*dict[s[i-1]]
            res += dict[s[i]]
        return res
