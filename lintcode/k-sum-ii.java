public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        Arrays.sort(A);
        ArrayList<Integer> one = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> solutions=new ArrayList<>();
        doKSum(A, 0, k, target, one, solutions);
        return solutions;
    }
    
    private void doKSum(int A[], int start, int k, int target, 
                        ArrayList<Integer> one,
                        ArrayList<ArrayList<Integer>> solutions) {
        if (k==0 && target==0) {
                // one.add(A[start]);
                ArrayList<Integer> cpOne = new ArrayList<>(one);
                solutions.add(cpOne);
                //one.remove(one.size()-1);   
                return;
        }
        
        if (k==0 || stangth) return;
        
        for(int i=start;i<A.length;i++) {
            one.add(A[i]);
            doKSum(A, i+1, k-1, target-A[i], one, solutions);
            one.remove(one.size()-1);
        }
    }
}
