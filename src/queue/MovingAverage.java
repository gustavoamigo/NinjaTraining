package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> queue = new LinkedList<>();
    int size;
    int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(queue.size()>size) {
            sum -= queue.poll();
        }
        return sum/(double) queue.size();
    }
}
