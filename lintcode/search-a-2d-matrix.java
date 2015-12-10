public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int m=matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        int[] a=new int[m];
        for(int i=0;i<m;i++) {
            a[i]=matrix[i][0];
        }
        
        int row=bsearchG(a, target);
        if(row==0) return false;
        int col=bsearchG(matrix[row-1], target);
        return matrix[row-1][col-1]==target;
    }
    // binary search for greater than
    int bsearchG(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        if(target>=arr[high]) return high+1;
        int mid=0;
        while(low<high) {
            mid = low + (high-low)/2;
            if(arr[mid]==target) return mid+1;
            if(arr[mid]>target) {
                hig           } else {
                low=mid+1;
            }
        }
        
        return mid+1;
    }
}
