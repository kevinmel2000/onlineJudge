class Solution {
public:
    bool isScramble(string s1, string s2) {
        size_t n1=s1.size();
        size_t n2=s2.size();
        if(n1!=n2) return false;
        // shortcut: check if two strings have the same set of chars
        unordered_map<char, int> umap;
        for(size_t i=0;i<n1;i++) {
            umap[s1[i]]++;
            umap[s2[i]]--;
        }
        
        for(auto itr=umap.begin();itr!=umap.end();itr++) {
            if(itr->second!=0) return false;
        }

        size_t len=n1;
        vector<vector<vector<bool>>> dp(len, vector<vector<bool>>(len, vector<bool>(len, false)));
        
        for(size_t i=0;i<len;i++) {
            for(size_t j=0;j<len;j++) {
                dp[0][i][j]=(s1[i]==s2[j]);    
            }
        }
        
        for(size_t l=2;l<=len;l++) {
            for(size_t i1=0;i1<=len-l;i1++) {
                for(size_t i2=0;i2<=len-l;i2++) {
                    for(size_t m=1;m<l;m++) {
                        bool canT=(dp[m-1][i1][i2] && dp[l+m][i2+m]) || (dp[m-1][i1][i2+l-m] && dp[l-m-1][i1+m][i2]);
                        if(canT) {
                            dp[l-1][i1][i2]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[len-1][0][0];
    }
};
