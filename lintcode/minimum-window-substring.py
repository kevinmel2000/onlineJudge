class Solution:
    """
    @param source: A string
    @param target: A string
    @return: A string denote the minimum window
             Return "" if there is no such a string
    """
    def minWindow(self, source, target):
        # write your code here
        pattern = {}
        found = {}
        for c in target:
            if not c in pattern:
                pattern[c]=1
            else:
                pattern[c]+=1
        
        count=0
        start=0
        minLen, minStart, minEnd=sys.maxint, 0, -1
        
        for i in range(len(source)):
            c = source[i]
            if c not in pattern:
                continue
            
            if c not in found:
                found[c]=1
            else:
                found[c]+=1
            
            if found[c]<=pattern[c]:
                count+=1
                
            if count==len(target):
                while start<=i:
                    sc = source[start]
                    if sc not in pattern:
                        start+=1
                    elif found[sc]>pattern[sc]:
                        found[sc]-=1
                        start+=1
                    else:
                        break
                if i-start+1<minLen:
                    minLen=i-start+1
                    minStart=start
                    minEnd=i
        
        return source[minStart:minEnd+1]
