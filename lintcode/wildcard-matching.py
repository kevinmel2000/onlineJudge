class Solution:
    """
    @param s: A string 
    @param p: A string includes "?" and "*"
    @return: A boolean
    """
    def isMatch(self, s, p):
        # write your code here
        i = 0; j=0
        star = None
        while i < len(s):
            if j<len(p) and (s[i]==p[j] or p[j]=='?'): i+=1; j+=1
            elif j<len(p) and p[j]=='*': star=j; ss=i; j+=1
            elif star is not None: j=star+1; ss+=1; i=ss
            else: return False

        while j<len(p) and p[j]=='*':
            j+=1
            
        return j==len(p)
    

