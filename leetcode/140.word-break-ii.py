class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        def wordRec(s, wordDict, resDict):
            myres = []
            if s in wordDict:
                myres.append(s)
            for i in xrange(len(s)-1):
                prefix,suffix = s[:i+1], s[i+1:]
                if prefix not in wordDict:
                    continue
                
                res = []
                if suffix in resDict:
                    res = resDict[suffix]
                else:
                    res = wordRec(suffix, wordDict, resDict)
                
                for r in res:
                    myres.append(prefix+' '+r)
            
            resDict[s]=myres
            return myres
        resDict = dict()
        return wordRec(s, wordDict, resDict)
