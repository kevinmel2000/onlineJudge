class Solution:
    # @param str: a string
    # @return an integer
    def atoi(self, str):
        # write your code here
        innum = False
        res = 0
        pre = 214747364
        intmax = 2147483647
        intmin = -2147483648
        negative = False
        for i in xrange(len(str)):
            if str[i].isdigit():
                innum = True
                d = ord(str[i])-ord('0')
                if (res > pre) or (res == pre and ((negative and d>8) or d>7)):
                    return intmin if negative else intmax
                res = res*10 + d
            else:
                if innum:
                    break
                elif str[i]=='+' or str[i]=='-':
                    if str[i]=='-':
                        negative = True
                    innum = True
                elif str[i]!=' ':
                    break
        return res*-1 if negative else res 
