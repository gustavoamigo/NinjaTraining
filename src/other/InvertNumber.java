package other;


/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
Example 1:
Input: x = 123
Output: 321
Example 2:
Input: x = -123
Output: -321
Example 3:
Input: x = 120
Output: 21
Example 4:
Input: x = 0
Output: 0
 */

public class InvertNumber {

    // 123

    // -123

    public static int invert(int num) {
        int result = 0;
        while(num != 0) {
            int firstDigit = num - (num / 10 * 10);
            num = num / 10;
            result *= 10;
            result += firstDigit;

            // Sanity check - detect edge cases
            int resultFirstDigit = result - (result / 10 * 10);
            if(resultFirstDigit != firstDigit) return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(invert(123));
        System.out.println(invert(-120));
        System.out.println(invert(-123));
        System.out.println(invert(-1234569933));
    }
}
