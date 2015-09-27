class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> solutions;
        vector<int> res;
        doCombine(candidates,target,0,res,solutions);
        return solutions;
    }
    
    void doCombine(vector<int>& candidates, int target, int index, vector<int>& res, vector<vector<int>>& solutions) {
        int n=candidates.size();
        if(target==0) {
            solutions.push_back(res);
            return;
        }
        
        if(target<0) {
            return;
        }

        for(int i=index;i<n;i++) {
            if(i>index && candidates[i]==candidates[i-1]) continue;
            res.push_back(candidates[i]);
            doCombine(candidates, target-candidates[i], i, res, solutions);
            res.pop_back();
        }
    }
};
