// 0: dead to dead
// 1: live to live
// 2: live to dead
// 3: dead to live

public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,-1},{-1,1}};
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int live = 0;
                for(int k=0;k<8;k++) {
                    int nx = i+dirs[k][0];
                    int ny = j+dirs[k][1];
                    if(nx<0 || ny>=n || nx>=m || ny<0) continue;
                    if(board[nx][ny]==1 || board[nx][ny]==2) live++;
                }
                
                if(board[i][j]==0 && live==3) {
                    board[i][j]=3;
                } else if(board[i][j]==1 && (live<2 || live>3)) {
                    board[i][j]=2;
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                board[i][j]%=2;
            }
        }
    }
}
