class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++) {
            Arrays.fill(row, false);
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.' && !checkAndSet(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean[] row=new boolean[9];
    private boolean[][] column=new boolean[9][9];
    private boolean[][] box=new boolean[9][9];
    private boolean checkAndSet(char[][] board, int i, int j) {
        int val=board[i][j]-'1';
        if(row[val] || 
            column[j][val] || 
                box[i/3*3+j/3][val]) return false;
        row[val]=column[j][val]=box[i/3*3+j/3][val]=true;
        return true;
    }
};
