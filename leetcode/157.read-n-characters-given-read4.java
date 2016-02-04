/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        while(!eof && total<n) {
            char[] sbuf = new char[4];
            int nRead = read4(sbuf);
            if (nRead<4) eof = true;
            int nBytes = Math.min(n-total, nRead);
            System.arraycopy(sbuf, 0, buf, total, nBytes);
            total+=nBytes;
        }
        return total;
    }
}
