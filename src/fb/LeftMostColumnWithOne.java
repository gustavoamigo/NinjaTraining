package fb;

import java.util.List;
/*
https://leetcode.com/problems/leftmost-column-with-at-least-a-one/solution/
 */
public class LeftMostColumnWithOne {
    class BinaryMatrix {
        public int get(int row, int col) {
            return 0;
        }

        public List<Integer> dimensions() {
            return null;
        }
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);

        int least = -1;

        for (int y = 0; y < rows; y++) {
            int l = 0;
            int r = cols - 1;
            int x = r / 2;
            while (l <= r) {
                int value = binaryMatrix.get(y, x);

                if (value == 1) {
                    int valueLeft = x > 0 ? binaryMatrix.get(y, x - 1) : 0;
                    if (valueLeft == 0) {
                        least = least == -1 ? x : Math.min(x, least);
                        break;
                    }
                }

                if (value == 1) { // go to left
                    r = x - 1;
                } else { // go to right
                    l = x + 1;
                }
                x = (l + r) / 2;
            }
        }
        return least;
    }
}
