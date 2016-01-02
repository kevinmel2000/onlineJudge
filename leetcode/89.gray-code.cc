class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> res;
        res.push_back(0);
        for(int i=0;i<n;i++){
            int n=res.size();
            int highbit=1<<i;
            for(int j=n-1;j>=0;j--){
                res.push_back(highbit+res[j]);
            }
        }
        return res;
    }
};
