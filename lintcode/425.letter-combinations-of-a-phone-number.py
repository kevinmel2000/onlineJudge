class Solution:
    # @param {string} digits A digital string
    # @return {string[]} all posible letter combinations
    def letterCombinations(self, digits):
        def printdigit(index):
            s=""
            for i in range(n):
                s+=digitrange[int(digits[i])][index[i]]
            return s
        # Write your code here
        digitrange = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        carry = 0
        n=len(digits)
        index = [0]*n
        res = []
        if n==0: return res
        while carry==0:
            res += [printdigit(index)]
            carry = 1
            for i in range(n-1,-1,-1):
                if index[i]+carry>=len(digitrange[int(digits[i])]):
                    index[i]=0
                    carry=1
                else:
                    index[i]+=carry
                    carry=0
        return res
