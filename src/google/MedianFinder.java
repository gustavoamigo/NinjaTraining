package google;

import java.util.TreeMap;
/*
https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {

    class OrderedMSet<T> {
        TreeMap<T, Integer> tree = new TreeMap<>();
        int size = 0;
        T last = null;
        T first = null;

        public void add(T value) {
            invalidateCache();
            tree.put(value, tree.getOrDefault(value, 0) + 1);
            size++;
        }

        public boolean remove(T value) {
            if(tree.containsKey(value) && tree.get(value) > 0 ) {
                Integer freq = tree.get(value);
                if(freq > 1) {
                    tree.put(value, freq - 1);
                } else {
                    tree.remove(value);
                }
                size --;
                return true;
            } else {
                return false;
            }
        }

        public int size() {
            return size;
        }

        private void invalidateCache() {
            last = null;
            first = null;
        }

        public boolean removeLast() {
            if(size > 0) {
                T value = last();
                invalidateCache();
                return  remove(value);
            } else {
                return false;
            }
        }

        public boolean removeFirst() {
            if(size > 0) {
                T value = first();
                invalidateCache();
                return  remove(value);
            } else {
                return false;
            }
        }

        public T last() {
            if(last == null) {
                last = tree.lastKey();
            }
            return last;
        }

        public T first() {
            if(first == null) {
                first = tree.firstKey();
            }
            return  first;
        }
    }

    OrderedMSet<Integer> higher = new OrderedMSet<>();
    OrderedMSet<Integer> lower = new OrderedMSet<>();


    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(lower.size() == 0 || num <= lower.last()) {
            lower.add(num);
        } else {
            higher.add(num);
        }
        rebalance();
    }

    private void rebalance() {
        if(lower.size() - higher.size() > 1) {
            higher.add(lower.last());
            lower.removeLast();
        } else if( higher.size() - lower.size() > 0 ) {
            lower.add(higher.first());
            higher.removeFirst();
        }
    }

    public double findMedian() {
        if(lower.size() - higher.size() == 0) {
            return ((double)(lower.last() + higher.first())/2);
        } else {
            return lower.last();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();

        //System.out.println(finder.findMedian());

        finder.addNum(1); // 1
        System.out.println(finder.findMedian());

        finder.addNum(3); // 1 3
        System.out.println(finder.findMedian());

        finder.addNum(5); // 1 3 5
        System.out.println(finder.findMedian());

        finder.addNum(2); // 1 2 3 5
        System.out.println(finder.findMedian());

        finder.addNum(7); // 1 2 3 5 7
        System.out.println(finder.findMedian());

        finder.addNum(3); // 1 2 3 3 5 7
        System.out.println(finder.findMedian());

        finder.addNum(3); // 1 2 3 3 3 5 7
        System.out.println(finder.findMedian());

        finder.addNum(7); // 1 2 3 3 3 5 7 7
        System.out.println(finder.findMedian());

        finder.addNum(7); // 1 2 3 3 3 5 7 7 7
        System.out.println(finder.findMedian());

        finder.addNum(7); // 1 2 3 3 3 5 7 7 7 7
        System.out.println(finder.findMedian());

    }
}
