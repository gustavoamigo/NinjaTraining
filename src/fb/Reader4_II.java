package fb;

/*
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/269/
 */
public class Reader4_II {

    private int read4(char[] buf) {
        return 0;
    }

    char[] buff4 = new char[4];
    int buff4Pos = 0;
    int buff4Size = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if(n == 0) return 0;
        int totalRead = 0;

        // flush buffer
        if(buff4Size > 0) {
            int leftToReadInFlush = Math.min(n, buff4Size);
            for(int i = 0; i < leftToReadInFlush; i++) {
                buf[i] = buff4[buff4Pos + i];
            }
            totalRead += leftToReadInFlush;

            buff4Pos += leftToReadInFlush;
            buff4Size = buff4Size - leftToReadInFlush;
            if(buff4Size <= 0) {
                buff4Pos = 0;
                buff4Size = 0;
            }
        }

        // read from read4
        while(n - totalRead > 0 ) {
            int read = read4(buff4);
            if(read == 0) {
                break;
            }
            int leftToReadInBuffer = Math.min(n - totalRead, read);
            for(int i = 0; i < leftToReadInBuffer; i++) {
                buf[i + totalRead] = buff4[i];
            }
            if(leftToReadInBuffer < 4) {
                buff4Pos = leftToReadInBuffer;
                buff4Size = read - leftToReadInBuffer;
            }

            totalRead += leftToReadInBuffer;
        }

        return totalRead;
    }
}
