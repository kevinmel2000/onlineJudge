public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{-1,-1});
        int n = height.length;
        int[] heights = new int[n+1];
        System.arraycopy(height, 0, heights, 0, n);
        heights[n]=-1;
        // System.out.println(Arrays.toString(heights));
        int marea = 0;
        for(int i=0;i<heights.length;i++) {
            int c = heights[i];
            while(stk.peek()[1]>c) {
                int hh = stk.peek()[1];
                stk.pop();
                int ii = stk.peek()[0];
                //System.out.println("ii="+ii+",hh="+hh);
                marea = Math.max(marea, hh*(i-ii-1)); 
            }
            stk.push(new int[]{i, c});
        }
        return marea;
    }
}

