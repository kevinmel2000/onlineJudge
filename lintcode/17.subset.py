class Solution:
    """
    @param S: The set of numbers.
    @return: A list of lists. See example.
    """
    def subsets(self, S):
        # write your code here
        def subsetRec(S, index, curList, solution):
            n = len(S)
            if index>=n:
                solution.append(curList[:])
                return 
            
            curList.append(S[index])
            subsetRec(S, index+1, curList, solution)
            curList.pop()
            subsetRec(S, index+1, curList, solution)
        
        solution = []
        curList = []
        S = sorted(S)
        subsetRec(S, 0, curList, solution)
        return solution
