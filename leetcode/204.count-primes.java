// Sieve of Eratosthenes complexity: O(n(logn)(loglogn))
public class Solution {
    public int countPrimes(int n) {
        boolean[] nonePrimes = new boolean[n+1];
        int count=0;
        for(int i=2;i<n;i++) {
            if(!nonePrimes[i]) {
                count++;
                for(int j=i+i;j<n;j+=i) {
                    nonePrimes[j]=true;
                }
            }
        }
        return count;
    }
}
