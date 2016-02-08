public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] ca = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++) {
            dp[i][i]=true;
        }
        
        int longest = 1;
        int maxStart = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(ca[i]==ca[j] && (i-j<2 || dp[j+1][i-1])) {
                    dp[j][i]=true;
                    if(i-j+1>longest) {
                        longest = i-j+1;
                        maxStart = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxStart+longest);
    }
}
