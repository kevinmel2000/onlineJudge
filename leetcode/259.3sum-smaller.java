public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length-2;i++) {
            int j=i+1, k=nums.length-1;
            while(j<k) {
                if(nums[i]+nums[j]+nums[k]<target) {
                    count+=k-j;
                    j++;
                }
                
                if(nums[i]+nums[j]+nums[k]>=target) {
                    k--;
                }
            }
        }
        return count;
    }
}
