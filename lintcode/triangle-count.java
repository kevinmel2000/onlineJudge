public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        Arrays.sort(S);
        int n=S.length;
        int count=0;
        for(int i=0;i<n-2;i++) {
            int k=i+2;
            for(int j=i+1;j<n-1;j++) {
                while(k<n && S[k]<S[i]+S[j]) {
                    k++;
                }
                count+=k-j-1;
            }
        }
        return count;
    }
}
