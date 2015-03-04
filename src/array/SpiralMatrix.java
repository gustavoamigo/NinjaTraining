package array;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix {

    static public ArrayList<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> spiral = new ArrayList<Integer>();
        
        if(matrix.length == 0) return spiral;
        
        int length = matrix[0].length * matrix.length;
        
        int x = 0;
        int y = 0;
        int p = 0;
        
        // Start to the right direction
        int incrementX = 1;
        int incrementY = 0;
        
        // Limits
        int upperLimit = 1;
        int leftLimit = 0;
        int rightLimit = matrix[0].length - 1;
        int bottomLimit = matrix.length - 1;
        
        // Start nagigating through the matrix
        while(p<length) {
            spiral.add(matrix[y][x]);
            if(x == rightLimit && incrementY == 0 && incrementX == 1) {
                incrementX = 0;
                incrementY = 1;
                rightLimit--;
            } else if(y == bottomLimit && incrementY == 1 && incrementX == 0) {
                incrementX = -1;
                incrementY = 0;
                bottomLimit--;
            } else if(x == leftLimit && incrementY == 0 && incrementX == -1) {
                incrementX = 0;
                incrementY = -1;
                leftLimit++;
            } else if(y == upperLimit && incrementX == 0 && incrementY == -1) {
                incrementX = 1;
                incrementY = 0;
                upperLimit++;
            }
            
            x += incrementX;
            y += incrementY;
            p++;
            
        }
        return spiral;    
    }
    
    public static void main(String[] args) {
    	
    	int[][] matrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};
    	ArrayList<Integer> spiral =  spiralOrder(matrix2);
    	System.out.print(Arrays.toString(spiral.toArray()));    	
	}
}
