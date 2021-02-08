package fb;

public class CountSubarrays {
    int[] countSubarrays(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = 1;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i]>arr[j]) {
                    result[i] ++;
                } else {
                    break;
                }
            }

            for(int j = i - 1; j >= 0; j--) {
                if(arr[i]>arr[j]) {
                    result[i] ++;
                } else {
                    break;
                }
            }

        }
        return result;
    }
}
