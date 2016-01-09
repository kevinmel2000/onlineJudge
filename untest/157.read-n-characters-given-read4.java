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
 
class Solution {
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
//public class Solution extends Reader4 {
   /**
    * @param buf Destination buffer
    * @param n   Maximum number of characters to read
    * @return    The number of characters read
    */
   public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        while (!eof && total<n) {
            char[] fourBytes = new char[4];
            int nread = read4(fourBytes);
            if(nread<4) eof=true;
            nread = Math.min(n-total, nread);
           
            // copy data
            System.arraycopy(fourBytes, 0, buf, total, nread);
            total+=nread;
        }
        return total;
   }
 
   int read4(char[] buf) {
        return 0;
   }
}
