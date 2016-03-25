public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0,count2=0;
        int cand1=0, cand2=0;
        
        for(int i=0;i<nums.length;i++) {
            if(count1!=0 && nums[i]==cand1) {
                count1++;
            } else if(count2!=0 && nums[i]==cand2) {
                count2++;
            } else if(count1==0) {
                cand1=nums[i];
                count1=1;
            } else if(count2==0) {
                cand2=nums[i];
                count2=1;
            } else {
                count1--;
                count2--;
            }
        }
        
        if(count1==0) count1=-1; else count1=0;
        if(count2==0) count2=-1; else count2=0;
        for(int i=0;i<nums.length;i++) {
            if(count1!=-1 && nums[i]==cand1) {
                count1++;
            }
            if(count2!=-1 && nums[i]==cand2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(count1>nums.length/3) res.add(cand1);
        if(count2>nums.length/3) res.add(cand2);
        return res;
    }
}
