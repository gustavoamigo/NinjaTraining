package fb;

import java.util.Random;

public class RotationalCipher {
    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        // Rotate 'a' to 'z'
        // Rotate 'A' to 'Z'
        // Rotate '0' to '9'


        char[] arr = input.toCharArray();

        double random = new Random().nextInt(10);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 'a' && arr[i] <= 'z') {
                int base = 'a';
                int length = 'z' - 'a' + 1;
                int pos =  arr[i] - 'a';
                int toCompleteRotate = length - pos;
                if(rotationFactor < toCompleteRotate) {
                    arr[i] += rotationFactor;
                } else {
                    int moreRotate = rotationFactor - toCompleteRotate;
                    int leftToRotate = moreRotate % length;
                    arr[i] = (char) (base + leftToRotate);
                }
            } else if(arr[i] >= 'A' && arr[i] <= 'Z') {
                int base = 'A';
                int length = 'Z' - 'A' + 1;
                int pos =  arr[i] - 'A';
                int toCompleteRotate = length - pos;
                if(rotationFactor < toCompleteRotate) {
                    arr[i] += rotationFactor;
                } else {
                    int moreRotate = rotationFactor - toCompleteRotate;
                    int leftToRotate = moreRotate % length;
                    arr[i] = (char) (base + leftToRotate);
                }
            } else if(arr[i] >= '0' && arr[i] <= '9') {
                int base = '0';
                int length = '9' - '0' + 1;
                int pos =  arr[i] - '0';
                int toCompleteRotate = length - pos;
                if(rotationFactor < toCompleteRotate) {
                    arr[i] += rotationFactor;
                } else {
                    int moreRotate = rotationFactor - toCompleteRotate;
                    int leftToRotate = moreRotate % length;
                    arr[i] = (char) (base + leftToRotate);
                }
            }
        }

        return new String(arr);
    }
}
