public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        return searchRec(matrix, 0, n-1, 0, m-1, target);
    }
    
    boolean searchRec(int[][] m, int l, int r, int u, int d, int target) {
        if(l>r || u>d) return false;
        int um = u+(d-u)/2;
        
        int low=l,high=r;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(m[um][mid]==target) return true;
            if(m[um][mid]>target) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return searchRec(m, low, r, u, um-1, target) || searchRec(m, l, low-1, um+1, d, target);
    }
}
