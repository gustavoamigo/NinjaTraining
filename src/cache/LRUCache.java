package cache;

import java.util.*;

/*
 * https://oj.leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private static class CacheItem {
        int key;
        int value;
        CacheItem prev;
        CacheItem next;
    }

    private CacheItem first;
    private CacheItem last;

    private int capacity;
    private int size = 0;
    private HashMap<Integer, CacheItem> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<> (capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        CacheItem cacheItem = this.cache.get(key);
        if(cacheItem == null) return -1;
        promote(cacheItem);
        return cacheItem.value;
    }

    public void put(int key, int value) {
        CacheItem cacheItem = this.cache.get(key);
        if(cacheItem == null) {
            if(size == capacity) dumpLast();
            CacheItem newItem = new CacheItem();
            newItem.key = key;
            newItem.value = value;
            this.cache.put(key, newItem);
            addToFirst(newItem);
        } else {
            cacheItem.value = value;
            promote(cacheItem);
        }
    }

    private void dumpLast() {
        this.cache.remove(this.last.key);
        removeFromList(this.last);
    }

    private void promote(CacheItem cacheItem) {
        removeFromList(cacheItem);
        addToFirst(cacheItem);
    }

    private void removeFromList(CacheItem cacheItem) {
        CacheItem prev = cacheItem.prev;
        CacheItem next = cacheItem.next;
        if(prev != null && next != null) {
            prev.next = next;
            next.prev = prev;
        } if (prev == null && next != null ) {
            this.first = next;
            next.prev = null;
        } if (prev != null && next == null ) {
            prev.next = null;
            this.last = prev;
        } if (prev == null && next == null ) {
            this.first = null;
            this.last = null;
        }
        size--;
    }

    private void addToFirst(CacheItem cacheItem) {
        CacheItem oldFirst = this.first;
        this.first = cacheItem;
        cacheItem.prev = null;
        if(oldFirst != null) {
            cacheItem.next = oldFirst;
            oldFirst.prev = cacheItem;
        } else if(oldFirst == null) {
            cacheItem.next = null;
            this.last = cacheItem;
        }
        size++;
    }

    public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
}
