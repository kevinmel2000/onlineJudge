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
 
//public class Solution extends Reader4 {
class Solution {
    private char[] buffer = new char[4];
    int offset = 0, bufSize = 0;
 
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        while(!eof && total<n) {
            if(bufSize==0) {
                int bufSize = read4(buffer);
                if(bufSize<4) eof = true;
            }
           
            int nread = Math.min(bufSize, n-total);
            System.arraycopy(buffer, offset, buf, total, nread);
            bufSize-=nread;
            offset=(offset+nread) & 3; // %4
            total+=nread;
        }
       
        return total;
    }
   
    int read4(char[] buf) {
        return 0;
    }
}
