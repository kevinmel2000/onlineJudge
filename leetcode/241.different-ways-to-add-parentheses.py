class Solution(object):
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        ans = []
        for i in range(len(input)):
            if input[i] in '*+-':
                left = self.diffWaysToCompute(input[:i])
                right = self.diffWaysToCompute(input[i+1:])
                for l in left:
                    for r in right:
                        if input[i]=='*':
                            ans.append(l*r)
                        elif input[i]=='+':
                            ans.append(l+r)
                        else:
                            ans.append(l-r)
        if not ans:
            ans.append(int(input))
        
        return ans;
