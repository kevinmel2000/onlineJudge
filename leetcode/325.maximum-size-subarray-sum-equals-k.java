public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if(sum==k && i+1>maxLen) maxLen = i+1;
            if(sumMap.get(sum-k)!=null) {
                for(Integer l : sumMap.get(sum-k)) {
                    if(i-l>maxLen) maxLen = i-l;    
                }
            }
            
            if(sumMap.get(sum)==null) sumMap.put(sum, new ArrayList<Integer>());
            sumMap.get(sum).add(i);
        }
        return maxLen;
    }
}
