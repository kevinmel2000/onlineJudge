class Solution:
    # @param {int} n an integer
    # @return {int[][]} a square matrix
    def generateMatrix(self, n):
        # Write your code here
        res = [[0]*n for i in range(n)]
        left,right,top,down = 0, n-1, 0, n-1
        index = 1
        while left<=right and top<=down:
            for i in xrange(left, right+1):
                res[top][i]=index
                index+=1
            top+=1
            
            for i in xrange(top, down+1):
                res[i][right]=index
                index+=1
            right-=1
            
            for i in xrange(right, left-1, -1):
                res[down][i]=index
                index+=1
            down-=1
            
            for i in xrange(down, top-1, -1):
                res[i][left]=index
                index+=1
            left+=1

        return res
