package fb;

import java.util.Arrays;

public class KClosestII {
    private void swap(double[] nums, int i, int j) {
        if(i == j) return;
        double aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    private int partition(double[] nums, int start, int end) {
        double pivot = nums[start];
        // move pivot to the end
        swap(nums, start, end);
        int index = start;

        // move small to the left
        for(int i = start ; i <= end ; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, index);
                index++;
            }
        }
        // move pivot back to the index
        swap(nums, end, index);
        return index;
    }

    private double quickselect(double[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while(true) {
            int index = partition(nums, start, end);
            if(index == k - 1) return nums[index];
            if(index < k - 1) { // our kth is on the right
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        double[] distances = new double[points.length];
        for(int i = 0; i < points.length; i++) {
            distances[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }

        double kthDistance = quickselect(distances, K);

        int[][] result = new int[K][2];
        int i = 0;
        for(int[] point: points) {
            if(i<result.length) {
                double distance = point[0] * point[0] + point[1] * point[1];
                if(distance <= kthDistance) {
                    result[i][0] = point[0];
                    result[i][1] = point[1];
                    i++;
                }
            } else {
                break;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        KClosestII solution = new KClosestII();
        int[][] result = solution.kClosest(points, 2);
        for(int[] point : result) {
            System.out.print(point[0]);
            System.out.print(" ");
            System.out.println(point[1]);
        }
    }
}
