class Solution:
    """
    @param matrix: A list of lists of integers
    @return: Nothing
    """
    def rotate(self, matrix):
        # write your code here
        n = len(matrix)
        for i in range(n):
            for j in range(i):
                matrix[i][j], matrix[j][i]=matrix[j][i], matrix[i][j]
        
        for i in range(n):
            for j in range(n/2):
                matrix[i][j], matrix[i][n-j-1]=matrix[i][n-j-1], matrix[i][j]
