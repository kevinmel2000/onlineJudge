/*
There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.
Could you please decide the first player will win or lose?
Example
Given array A = [3,2,2], return true.
Given array A = [1,2,4], return true.
Given array A = [1,20,4], return false.
Challenge Follow Up Question:
If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?
*/

class Solution {
public:
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    bool firstWillWin(vector<int> &values) {
        // write your code here
        int n=values.size();
        int sum=0;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for(int j=0;j<n;j++) {
            sum+=values[j];
            for(int i=j;i>=0;i--) {
                if(j-i<2) {
                    dp[i][j]=max(values[i], values[j]);
                } else {
                    dp[i][j]=max(values[i]+min(dp[i+1][j-1], dp[i+2][j]), values[j]+min(dp[i+1][j-1], dp[i][j-2]));          
                }
            }
        }
        return dp[0][n-1]>sum-dp[0][n-1];
    }
};
