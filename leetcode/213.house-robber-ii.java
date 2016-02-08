public class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        return Math.max(robOne(nums, 1, n-1), robOne(nums, 0, n-2));
    }
    
    int robOne(int[] nums, int i, int j) {
        if(i==j) return nums[i];
        int f1 = Math.max(nums[i],nums[i+1]);
        int f2 = nums[i];
        for(int k=2;k<j-i+1;k++) {
            int tmp = Math.max(f2+nums[k+i],f1);
            f2=f1;
            f1=tmp;
        }
        return f1;
    }
}
