public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int totalRed = costs[0][0];
        int totalBlue = costs[0][1];
        int totalGreen = costs[0][2];
        for(int i=1;i<costs.length;i++) {
            int oldRed = totalRed, oldBlue = totalBlue, oldGreen = totalGreen;
            totalRed = costs[i][0] + Math.min(oldBlue, oldGreen);
            totalBlue = costs[i][1] + Math.min(oldRed, oldGreen);
            totalGreen = costs[i][2] + Math.min(oldRed, oldBlue);
        }
        
        return Math.min(totalRed, Math.min(totalBlue, totalGreen));
    }
}
