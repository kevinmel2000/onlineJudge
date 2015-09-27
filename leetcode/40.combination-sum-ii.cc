class Solution {
public:
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        sort(num.begin(), num.end());
        vector<int> res;
        vector<vector<int>> solutions;
        doCombineSum(num, 0, target, res, solutions);
        return solutions;
    }
    
    void doCombineSum(vector<int> &num, int depth, int target, vector<int>& res, vector<vector<int>>& solutions)
    {
        int n=num.size();
        if(target==0){
            solutions.push_back(res);
            return;
        }
        if(target<0 || depth>=n) return;
        
        for(int i=depth; i<n;i++){
            if(i!=depth && num[i-1]==num[i]) continue;
            res.push_back(num[i]);
            doCombineSum(num, i+1, target-num[i], res, solutions);
            res.pop_back();
        }
    }
};
