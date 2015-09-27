class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<int> res;
        vector<vector<int>> solutions;
        doCombine(1, n, k, res, solutions);
        return solutions;
    }
    
    void doCombine(int index, int n, int k, vector<int>& res, vector<vector<int>>& solutions){
        if(res.size()==k) { 
            solutions.push_back(res);
            return;
        }
        for(int i=index; i<=n; i++){
            res.push_back(i);
            doCombine(i+1, n, k, res, solutions);
            res.pop_back();
        }
    }
};
