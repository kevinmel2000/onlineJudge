class Solution:
    # @param {int} n n pairs
    # @return {string[]} All combinations of well-formed parentheses
    def generateParenthesis(self, n):
        # Write your code here
        def doGen(left, right, res, solution):
            if left==0 and right==0:
                solution.append(''.join(res))
                return
            
            if left>0:
                res.append('(')
                doGen(left-1, right, res, solution)
                res.pop()
            
            if left<right:
                res.append(')')
                doGen(left, right-1, res, solution)
                res.pop()
            
        
        res = []
        solution = []
        doGen(n, n, res, solution)
        return solution
