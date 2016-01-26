public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
     String[] digitMap = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        
        StringBuilder sb = new StringBuilder();
        ArrayList<String> solution = new ArrayList<>();
        if(digits.isEmpty()) return solution;
        combineRec(digits, 0, sb, solution);
        return solution;
     }
    
     void combineRec(String digits, int start, StringBuilder res, ArrayList<String> solution) {
        int n = digits.length();
        if(start>=n) {
            solution.add(res.toString());
            return;
        }

        String cur = digitMap[digits.charAt(start)-'0'];
        for(int i=0;i<cur.length();i++) {
            res.append(cur.charAt(i));
            combineRec(digits, start+1, res, solution);
            res.setLength(res.length()-1);
        }
     }
}
