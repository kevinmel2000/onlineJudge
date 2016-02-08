public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int low=(n+1)/2, high=n;
        int[] tmp=new int[n];
        for(int i=0;i<n;i++) {
            if((i&1)==0) tmp[i]=nums[--low];
            else tmp[i]=nums[--high];
        }
        for(int i=0;i<n;i++) {
            nums[i]=tmp[i];
        }
    }
}
