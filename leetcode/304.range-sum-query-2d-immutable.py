class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if not matrix: return
        m = len(matrix)
        n = len(matrix[0])
        self.idxSum = [[0]*n for i in xrange(m)]
        for i in xrange(len(matrix)):
            for j in xrange(len(matrix[0])):
                self.idxSum[i][j]=matrix[i][j]
                if i>0:
                    self.idxSum[i][j]+=self.idxSum[i-1][j]
                if j>0:
                    self.idxSum[i][j]+=self.idxSum[i][j-1]
                
                if i>0 and j>0:
                    self.idxSum[i][j]-=self.idxSum[i-1][j-1]

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        sumR = self.idxSum[row2][col2]
        if row1>0:
            sumR-=self.idxSum[row1-1][col2]
        
        if col1>0:
            sumR-=self.idxSum[row2][col1-1]
            
        if row1>0 and col1>0:
            sumR+=self.idxSum[row1-1][col1-1]
        return sumR

# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)
