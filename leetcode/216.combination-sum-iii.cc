class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<int> res;
        vector<vector<int>> solutions;
        doCombSum3(1, k, n, res, solutions);
        return solutions;
    }
    
    void doCombSum3(int index, int k, int n, vector<int>&res, vector<vector<int>>& solutions) {
        if(res.size()==k && n==0) {
            solutions.push_back(res);
            return;
        }
        
        if(res.size()>k || n<0) {
            return;
        }

        for(int i=index;i<=9;i++) {
            res.push_back(i);
            doCombSum3(i+1, k, n-i, res, solutions);
            res.pop_back();
        }
    }
};
