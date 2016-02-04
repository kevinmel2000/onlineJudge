public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> us = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(us.contains(nums[i])) return true;
            us.add(nums[i]);
        }
        return false;
    }
}
