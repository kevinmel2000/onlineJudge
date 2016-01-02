class Solution:
    """
    @param n: n
    @param k: the k-th permutation
    @return: a string, the k-th permutation
    """
    import math
    def getPermutation(self, n, k):
        digits = range(1, n+1)
        factor = math.factorial(n)
        res = ""
        k-=1
        for i in range(n, 0, -1):
            factor/=i # last factor is 1,  think of basic division
            index = k/factor
            res+=str(digits.pop(index))
            k%=factor
            
        return res
