public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices.length==0) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i]>min && prices[i]-min>maxProfit) {
                maxProfit = prices[i]-min;
            }
            if(prices[i]<min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
