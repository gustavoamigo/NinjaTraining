package fb;

/*
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/268/
 */
public class Reader4 {
    private int read4(char[] buf) {
        return 0;
    }
    public int read(char[] buf, int n) {
        if(n == 0) return 0;
        char[] buff4 = new char[4];
        int totalRead = 0;
        boolean eof = false;
        while(n - totalRead > 0 && eof == false) {
            int read = read4(buff4);
            if(read < 4) eof = true;
            int leftToReadInBuffer = Math.min(n - totalRead, read);
            for(int i = 0; i < leftToReadInBuffer; i++) {
                buf[i + totalRead] = buff4[i];
            }
            totalRead += leftToReadInBuffer;
        }
        return totalRead;
    }
}
