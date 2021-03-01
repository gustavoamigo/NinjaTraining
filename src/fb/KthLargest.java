package fb;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class KthLargest {

//    PriorityQueue<Integer> priorityQueue =
//            new PriorityQueue<>((a, b) -> Integer.compare(b,a));
//    int k;
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        for(int n: nums) priorityQueue.add(n);
//    }
//
//    public int add(int val) {
//        priorityQueue.add(val);
//        Stack<Integer> a = new Stack<>();
//        while(a.size() < k) a.add(priorityQueue.poll());
//
//        int kthLargest = a.peek();
//        while(!a.isEmpty()) priorityQueue.add(a.pop());
//
//        return kthLargest;
//    }

    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        // 1,1,2,3,4
        KthLargest kthLargest = new KthLargest(3, new int[] {5,5,5,1,1,1});
        System.out.println(kthLargest.add(1));
    }
}
