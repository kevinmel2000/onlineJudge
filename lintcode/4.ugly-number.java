class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        Queue<Long> q3=new LinkedList<Long>();
        Queue<Long> q5=new LinkedList<Long>();
        Queue<Long> q7=new LinkedList<Long>();
        q3.add(3L);
        q5.add(5L);
        q7.add(7L);

        int count=0;
        long minC=0;
        while(count<k) {
            minC=Math.min(q7.peek(), Math.min(q3.peek(), q5.peek()));
            if (minC == q7.peek()) {
                q7.remove();
            } else {
                if (minC == q5.peek()) {
                    q5.remove();
                } else { // must be from Q3
                    q3.remove();
                    q3.add(minC*3);
                }
                q5.add(minC*5);
            }
            q7.add(minC*7);
            count++;
        }
        return minC;
    }
};
