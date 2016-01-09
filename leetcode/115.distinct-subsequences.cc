class Solution {
public:
    int numDistinct(string S, string T) {
        int ns=S.size();
        int nt=T.size();
        
        int dp[nt+1];
        dp[0]=1;
        for(int i=1;i<=nt;i++){
            dp[i]=0;
        }
        //
        //for(int i=0;i<=ns;i++){
        //    dp[i][0]=1;
        //}

        for(int i=1;i<=ns;i++){
            for(int j=nt;j>0;j--) {
                if(S[i-1]==T[j-1]) {
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[nt];
    }
};
