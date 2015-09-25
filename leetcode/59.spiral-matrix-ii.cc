class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        //int m=n*n
        vector<vector<int>> res(n, vector<int>(n, 0));
        int left=0, right=n-1, top=0, down=n-1;
        int i=1;
        while(i<=n*n) {
            // top
            for(int j=left;j<=right;j++) {
                res[top][j]=i++;
            }
            top++;
            for(int j=top;j<=down;j++) {
                res[j][right]=i++;
            }
            right--;
            for(int j=right;j>=left;j--) {
                res[down][j]=i++;
            }
            down--;
            for(int j=down;j>=top;j--) {
                res[j][left]=i++;
            }
            left++;
        }
        return res;
    }
};
