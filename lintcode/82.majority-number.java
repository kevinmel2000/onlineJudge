public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int candidate=nums.get(0), count=1;
        for(int i=1;i<nums.size();i++) {
            if(nums.get(i)!=candidate) {
                count--;
                if(count==0) {
                    candidate=nums.get(i);
                    count=1;
                }
            } else {
                count++;
            }
        }
        return candidate;
    }
}
