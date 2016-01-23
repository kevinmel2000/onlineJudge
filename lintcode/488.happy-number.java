public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        Set<Integer> numSet = new HashSet<>();
        while(!numSet.contains(n)) {
            numSet.add(n);
            n=numSum(n);
            if(n==1) {
                return true;
            }
        }
        return false;
    }
    
    int numSum(int n) {
        int sum=0;
        while(n>0) {
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}
