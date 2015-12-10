class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m=matrix.size();
        if(m==0) return false;
        int n=matrix[0].size();
        int low=0, high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(matrix[mid][0]==target) return true;
            if(matrix[mid][0]<target) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        if(high<0) return false;
        int l=1, h=n-1;
        while(l<=h) {
            int mid=l+(h-l)/2;
            if(matrix[high][mid]==target) return true;
            if(matrix[high][mid]<target) {
                l=mid+1;
            } else {
                h=mid-1;
            }
        }
        return false;
    }
};
