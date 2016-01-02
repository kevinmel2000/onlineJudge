class Solution:
    # @param {int} n the nth
    # @return {string} the nth sequence
    def countAndSay(self, n):
        # Write your code here
        pre = "1"
        for i in range(1, n):
            count=1
            cur=""
            for j in range(1, len(pre)+1):
                if j==len(pre) or pre[j]!=pre[j-1]:
                    cur+=str(count)+pre[j-1]
                    count=1
                else:
                    count+=1
            pre=cur
        return pre
