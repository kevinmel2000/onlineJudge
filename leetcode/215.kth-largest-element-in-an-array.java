import java.util.*;
public class Solution {
    Random rndno = new Random();
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<k) return -1;
        return findKRec(nums, 0, nums.length-1, k);
    }
    
    int randomPartition(int[] nums, int l, int h) {
        int rndIdx = rndno.nextInt(h-l+1)+l;
        swap(nums, l, rndIdx);
        int end=l;
        for(int i=l+1;i<=h;i++) {
            if(nums[i]>=nums[l]){
                swap(nums, ++end, i);
            }
        }
        swap(nums, l, end);
        return end;
    }
    
    int findKRec(int[] nums, int l, int h, int k) {
        int m = randomPartition(nums, l, h);
        int kth = m-l+1;
        if(kth==k) {
            return nums[m];
        }
        
        if(kth>k)
            return findKRec(nums, l, m-1, k);
        else
            return findKRec(nums, m+1, h, k-kth);
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
