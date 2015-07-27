public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        Integer can1=null, can2=null;
        int count1=0, count2=0;
        for(int i=0;i<nums.size();i++) {
            if(can1!=null && can1.intValue()==nums.get(i)) {
                count1++;   
            } else if(can2!=null && can2.intValue()==nums.get(i)) {
                count2++;
            } else if(count1==0) {
                can1=nums.get(i);
                count1=1;
            } else if(count2==0) {
                can2=nums.get(i);
                count2=1;
            } else {
                count1--;
                count2--;
            }
        }

        count1=count2=0;
        for(int i=0;i<nums.size();i++) {
            if(can1.intValue()==nums.get(i)) {
                count1++;
            } else if(can2.intValue()==nums.get(i)) {
                count2++;
            }
        }
        return count1>nums.size()/3 ? can1 : can2;
    }
}
