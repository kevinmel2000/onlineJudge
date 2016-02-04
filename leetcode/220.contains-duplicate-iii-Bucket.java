public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t<0) return false;
        t++;
        Map<Integer, Integer> um = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(i>k) um.remove(getId(nums[i-k-1], t));
            int m = getId(nums[i], t);
            if(um.containsKey(m)) return true;
            if(um.containsKey(m-1) && Math.abs(um.get(m-1)-nums[i])<t) return true;
            if(um.containsKey(m+1) && Math.abs(um.get(m+1)-nums[i])<t) return true;
            um.put(m, nums[i]);
        }
        return false;
    }
    
    int getId(int val, int t) {
        return val<0? (val+1)/t-1:val/t;
    }
}
