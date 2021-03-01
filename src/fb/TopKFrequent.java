package fb;

import java.util.*;

public class TopKFrequent {
    private void swap(List<Integer> list, int i, int j) {
        if(i == j) return;
        int aux = list.get(i);
        list.set(i, list.get(j));
        list.set(j, aux);
    }

    private int partition(List<Integer> list, int start, int end) {
        int pivot = list.get(start);
        swap(list, start, end);
        int index = start;
        for(int i = start; i<=end; i++) {
            if(list.get(i) < pivot) {
                swap(list, i, index);
                index++;
            }
        }
        swap(list, index, end);
        return index;
    }

    private Integer quickselect(List<Integer> list, int k) {
        int start = 0;
        int end = list.size() - 1;
        while(true) {
            int index= partition(list, start, end);
            if(index == list.size() - k) return list.get(index);
            if(index < list.size() - k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
    }


    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(freq.values());
        Integer kthMostFreq = quickselect(values, k);
        int[] result = new int[k];
        int i = 0;
        for(int key: freq.keySet()) {
            if(freq.get(key)>=kthMostFreq && i < result.length) {
                result[i] = key;
                i++;
            }
        }

        return result;
    }

}
