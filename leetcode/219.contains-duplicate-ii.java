public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> us = new HashSet<>();
        
        for(int i=0;i<nums.length;i++) {
            if(i>k) us.remove(nums[i-k-1]);
            if(us.contains(nums[i])) return true;
            us.add(nums[i]);
        }
        return false;
    }
}
