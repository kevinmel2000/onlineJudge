public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int np = primes.length;
        int[] pointers = new int[np];
        int[] dp = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++) {
            int min = Integer.MAX_VALUE;
            for(int k=0;k<np;k++) {
                if(min>dp[pointers[k]]*primes[k]) {
                    min = dp[pointers[k]]*primes[k];
                }
            }
            dp[i]=min;
            for(int k=0;k<np;k++) {
                if(min==dp[pointers[k]]*primes[k]) {
                    pointers[k]++;
                }
            }
        }
        return dp[n-1];
    }
}
