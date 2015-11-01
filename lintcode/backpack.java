public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) dp[i][0] = 0;
        for(int i=0; i<=n; i++) dp[0][i] = 0;

        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++) {
                if(A[j-1]>i) {
                    dp[i][j]=dp[i][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-A[j-1]][j-1]+A[j-1], dp[i][j-1]);
                }
            }
        
        return dp[m][n];
    }
}

