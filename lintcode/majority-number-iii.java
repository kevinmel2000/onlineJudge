public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Map<Integer, Integer> cands=new HashMap<Integer, Integer>();
        for(int i : nums) {
            if(cands.containsKey(i)) {
                cands.put(i, cands.get(i)+1);
            } else if(cands.size()<k-1) {
                cands.put(i, 1);   
            } else {
                for(Iterator<Map.Entry<Integer, Integer>> itr=cands.entrySet().iterator(); itr.hasNext();){
                    Map.Entry en=itr.next();
                    int key=(int) en.getKey();
                    int value=(int) en.getValue();
                    value--;
                    if(value==0) {
                        itr.remove();
                    } else {
                        cands.put(key, value);    
                    }
                }
            }
        }
        for(Map.Entry en : cands.entrySet()) { en.setValue(0);}
        int cand=0;
        int count=0;
        for(int i : nums) {
            if(cands.containsKey(i)) {
                cands.put(i, cands.get(i)+1);
                if(cands.get(i)>count) {
                    count=cands.get(i);
                    cand=i;
                }
            }
        }
        if(count>nums.size()/k) return cand; 
        return -1;
    }
}
