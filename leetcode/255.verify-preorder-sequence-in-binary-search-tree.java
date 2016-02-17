public class Solution {
    Stack<Integer> preord = new Stack<>();
    Stack<Integer> inord = new Stack<>();
    public boolean verifyPreorder(int[] preorder) {
        
        for(int i : preorder) {
            if(!inord.isEmpty() && i<inord.peek()) {
                return false;
            }
            while(!preord.isEmpty() && i>preord.peek()) {
                inord.push(preord.pop());
            }
            preord.push(i);
        }
        return true;
    }
}
