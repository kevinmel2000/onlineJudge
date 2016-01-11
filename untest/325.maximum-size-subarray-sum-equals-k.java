/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
        public static void main (String[] args) throws java.lang.Exception
        {
                // your code goes here
        }
}

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> umap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int i=0;i<nums.length;i++) {
                left+=nums[i];
                if(left==k && maxLen<i+1) {
                        maxLen = i+1;
                }
                
                if(umap.containsKey(left-k)) {
                        int other = umap.get(k-left);
                        if(i-other>maxLen) {
                                maxLen = i-other;
                        }
                }
                
                if(!umap.containsKey(left)){
                        umap.put(left, i);
                }
        }
        return maxLen;
    }
}
