package other;

/*
 * https://oj.leetcode.com/problems/candy/
 */
public class CandyProblem {

    public int candy(int[] ratings) {
        
        int c[] = new int[ratings.length];
        int sum = 0;
        
        for(int i = 0; i< ratings.length; i++) {
            c[i] = 1;
        }
        
        for(int i = 1; i< ratings.length; i++ ) {
            if(ratings[i] > ratings[i-1] ) {
                c[i] = c[i-1] + 1;
            }
        }
        
        for(int i = ratings.length - 2; i>=0 ; i-- ) {
            if(ratings[i] > ratings[i+1] && c[i] <= c[i+1]) {
                c[i] = c[i+1] + 1;
            }
        }
        
        for(int i = 0; i< ratings.length; i++) {
            sum += c[i];
        }
        return sum;
    }

}
