class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        size_t m=matrix.size();
        vector<int> res;
        if(m==0) return res;
        size_t n=matrix[0].size();
        int left=0, right=n-1, top=0, down=m-1;
        
        while(left<=right && top<=down) {
            for(int i=left;i<=right;i++) {
                res.push_back(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=down;i++) {
                res.push_back(matrix[i][right]);
            }
            right--;
            for(int i=right;i>=left;i--) {
                res.push_back(matrix[down][i]);
            }
            down--;
            for(int i=down;i>=top;i--) {
                res.push_back(matrix[i][left]);
            }
            left++;
        }
        
        if (left < right && top == down) //for odd fat matrix
                for (int j = left; j <= right; ++j)
                        res.push_back(matrix[top][j]);
        
        if (top < down && left == right) //for odd len matrix
                for (int i = top; i <= down; ++i)
                        res.push_back(matrix[i][right]);
        
        if (top == down && left == right) //for odd sqaure matrix
                res.push_back(matrix[top][left]);

        return res;
    }
};
