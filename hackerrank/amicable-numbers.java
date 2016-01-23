import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        divisorSum();
        int t = Integer.parseInt(br.readLine());
        while(--t>=0) {
            int cur = Integer.parseInt(br.readLine());
            //pw.println(divSum[cur]+','+divSum[divSum[cur]]);
            if(divSum[divSum[cur]]==cur) {
                pw.println("Yes, amicable with " + divSum[cur]);
            } else {
                pw.println("No");
            }
        }
        pw.close();
    }
    
    static int divSum[] = new int[1000001];
    
    static void divisorSum() {
        divSum[1]=1;
        for(int i=2;i<divSum.length;i++) {
            int sum = 1;
            int sqrt = (int) Math.sqrt(i);
            for(int j=2;j<sqrt;j++) {
                if(i%j==0) {
                    sum+=j;
                    if((i/j)!=j) {
                        sum+=i/j;
                    }
                    divSum[i]=sum;
                }
            }
        }
    }
}
