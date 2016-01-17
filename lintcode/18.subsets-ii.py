class Solution:
    """
    @param S: A set of numbers.
    @return: A list of lists. All valid subsets.
    """
    def subsetsWithDup(self, S):
        # write your code here
        def subsetsRec(S, index, curList, solution):
            n = len(S)
            if index>=n:
                solution.append(list(curList))
                return
            
            curList.append(S[index])
            subsetsRec(S, index+1, curList, solution)
            curList.pop()
            
            while index<n-1 and S[index]==S[index+1]: index+=1
            subsetsRec(S, index+1, curList, solution)
        
        S = sorted(S)
        curList = []
        solution = []
        subsetsRec(S, 0, curList, solution)
        return solution
