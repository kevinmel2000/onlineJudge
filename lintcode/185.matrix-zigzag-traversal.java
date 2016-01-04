public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int m=matrix.length;
        int n=matrix[0].length;
        int[] res=new int[m*n];
        boolean down=false;
        int i=0,j=0;
        for(int nth=0;nth<m*n;nth++) {
            res[nth]=matrix[i][j];
            if(down) {
                if(i+1>=m || j-1<0) {
                    if(i+1<m) {
                        i=i+1;
                    } else {
                        j=j+1;
                    }
                    down=!down;
                } else {
                    i=i+1;
                    j=j-1;
                }
            } else {
                if(i-1<0 || j+1>=n) {
                    if(j+1<n) {
                        j=j+1;
                    } else {
                        i=i+1;
                    }
                    down=!down;
                } else {
                    i=i-1;
                    j=j+1;
                }
            }
        }
        return res;
    }
}
