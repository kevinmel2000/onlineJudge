public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    private Stack<String> ops = new Stack<String>();
    private ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
        for(int i=expression.length-1; i>=0;i--) {
            String s = expression[i];
            if(!isOps(s)) {
                res.add(s);
            } else {
                while(!ops.empty() && hasPrecedence(ops.peek(), s)) {
                    computeAndPush();
                }
                
                if(s.equals("(")) {
                    ops.pop();
                } else {
                    ops.push(s);
                }
            }
        }
        while(!ops.empty()){
            computeAndPush();
        }
        Collections.reverse(res);
        return res;
    }
    private boolean isOps(String s) {
        return s.equals("+") || s"-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")");
    }
    private boolean hasPrecedence(String op1, String op2) {
        if(op2.equals("(") && !op1.equals(")")) return true;
        if((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) return true;
        return false;
    }
    private void computeAndPush() {
        String s=ops.pop();
        res.add(s);
    }
    
}

