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
        for(int v : values) {
            sum+=v;
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        int res=minMax(values, 0, n-1, dp);
        if(res>sum-res) return true;
        return false;
    }
   
    int minMax(vector<int>& values, int left, int right, vector<vector<int>>& dp) {
        if(dp[left][right]!=-1) return dp[left][right];
        if(right-left<2) {
            dp[left][right]=max(values[right], values[left]);
            return dp[left][right];
        }
       
        dp[left][right]=max(values[left]+min(minMax(values, left+2, right, dp), minMax(values, left+1, right-1, dp)), values[right]+min(minMax(values, left, right-2, dp), minMax(values, left+1, right-1, dp)));
        return dp[left][right];
    }
};
