public class Solution {
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        
        if(num1.equals("0") || num2.equals("0")) return "0";
        char[] res = new char[n1+n2];
        Arrays.fill(res, '0');
        for(int i=n1-1;i>=0;i--) {
            int carry = 0;
            int d1 = num1.charAt(i)-'0';
            int j=n2-1;
            for(;j>=0;j--) {
                int d2 = num2.charAt(j)-'0';
                int r = res[i+j+1]-'0';
                int totalSum = d1*d2+carry+r;
                int d = totalSum%10;
                carry = totalSum/10;
                res[i+j+1]=(char)(d+'0');
            }
            
            if(carry!=0) {
                int totalSum = carry + res[i+j+1]-'0';
                res[i+j+1]=(char)(totalSum%10+'0');
            }
        }
        int startIdx = res[0]=='0'? 1:0;
        return new String(res, startIdx, res.length-startIdx);
    }
}
