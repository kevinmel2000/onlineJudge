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
            if(bufSize==0) {
                bufSize = read4(buffer);
                if(bufSize<4) {
                    eof = true;
                }
            }
            
            int nread = Math.min(bufSize, n-total);
            System.arraycopy(buffer, offset, buf, total, nread);
            total+=nread;
            offset = (offset+nread) & 3;
            bufSize-=nread;
        }
        return total;
    }
    
    int offset, bufSize;
    char[] buffer = new char[4];
}
