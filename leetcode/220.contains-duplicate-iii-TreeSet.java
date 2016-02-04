public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for(int i=0;i<n;i++) {
            if(k<i) ts.remove((long)nums[i-k-1]);
            long leftv = (long)nums[i]-t;
            long rightv = (long)nums[i]+t;
            if(leftv<=rightv && !ts.subSet(leftv, rightv+1).isEmpty()) return true;
            ts.add((long)nums[i]);
        }
        return false;
    }
}
