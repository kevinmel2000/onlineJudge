class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        def solveRec(board, pos):
            if pos==81: return True
            i = pos/9
            j = pos - pos/9*9
            if board[i][j]=='.':
                for k in range(9):
                    if not (row[i][k] or column[j][k] or box[i/3*3+j/3][k]):
                        board[i][j]=str(k+1)
                        row[i][k]=column[j][k]=box[i/3*3+j/3][k]=True
                        if solveRec(board, pos+1):
                            return True
                        board[i][j]='.'
                        row[i][k]=column[j][k]=box[i/3*3+j/3][k]=False
            else:
                return solveRec(board, pos+1) 
        row = [[False for i in range(9)] for j in range(9)]
        column = [[False for i in range(9)] for j in range(9)]
        box = [[False for i in range(9)] for j in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j]!='.':
                    k = ord(board[i][j])-ord('1')
                    row[i][k]=column[j][k]=box[i/3*3+j/3][k]=True
    
        solveRec(board, 0)
