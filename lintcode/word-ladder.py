class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return an integer
    def ladderLength(self, start, end, dict):
        # write your code here
        step = 2
        set1 = {start}
        set2 = {end}
        visited = {start, end}
        while set1:
            from string import lowercase
            if len(set1)>len(set2):
                set1,set2=set2,set1
            newSet = set([])
            for s in set1:
                for i in range(len(s)):
                    for c in lowercase:
                        newString = s[:i]+c+s[i+1:]
                        if newString in set2: return step
                        if newString in dict and newString not in visited:
                            visited.add(newString)
                            newSet.add(newString)
            step+=1        
            set1=newSet
        return 0
