class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        size_t m=matrix.size();
        size_t n=matrix[0].size();
        
        for(size_t i=0;i<m;i++) {
            for(size_t j=0;j<i;j++) {
                swap(matrix[i][j], matrix[j][i]);
            }
        }
        
        for(size_t i=0;i<m;i++) {
            for(size_t j=0;j<n/2;j++) {
                swap(matrix[i][j], matrix[i][n-j-1]);
            }
        }
    }
};
