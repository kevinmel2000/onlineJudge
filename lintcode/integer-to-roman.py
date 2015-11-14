class Solution:
    # @param {int} n The integer
    # @return {string} Roman representation
    def intToRoman(self, n):
        # Write your code here
        roman = ['I', 'V', 'X', 'L','C','D','M']
        base = 1000
        res = ''
        for i in range(6, -1, -2):
            digit = n/base
            if digit == 9:
                res += roman[i] + roman[i+2]
            elif digit >= 6 and digit <=8:
                res += roman[i+1] + roman[i]*(digit-5)
            elif digit == 5:
                res += roman[i+1]
            elif digit == 4:
                res += roman[i] + roman[i+1]
            elif digit >=1 and digit <=3:
                res += roman[i]*digit
            n %=base
            base/=10
        return res
