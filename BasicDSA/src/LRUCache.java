import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */

/*
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * 
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * 
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 */
public class LRUCache {

	// Map
	// Have an initial positive size capacity
	// if at max, and new incoming val, remove least used key-value
	
	private HashMap<Integer, Integer> lruCache;
	private Queue<Integer> usage;
	private int capacity;
	private int capacityCounter = 0;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		lruCache = new HashMap<>(capacity);
		usage = new LinkedList<>();
	}

	public int get(int key) {
		if (lruCache.containsKey(key)) {
			removeLRUStalePointer(key);
			if ( !usage.contains(key) ) {
				usage.offer(key);
			}
			return lruCache.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if ( capacityCounter < capacity ) {
			if ( lruCache.containsKey(key) ) {
				removeLRUStalePointer(key);
			}
			add(key, value);
			capacityCounter++;
		} else {
			if ( !lruCache.containsKey(key) ) {
				removeLRUValFromCache();
			}
			add(key, value);
		}
	}

	private void add(int key, int value) {
		lruCache.put(key, value);
		if ( !usage.contains(key) ) {
			usage.offer(key);
		} else {
			Integer removedVal = removeLRUStalePointer(key);
			if ( removedVal != null ) {
				usage.offer(key);
			}
		}
		System.out.println("Added key-val to cache: " + key + ", " + value);
	}
	
	private Integer removeLRUStalePointer(int key) {
		if ( usage.peek() == (Integer) key ) {
			return usage.poll();
		}
		return null;
	}
	
	private void removeLRUValFromCache() {
		Integer key = usage.poll();
		if ( key != null ) {
			lruCache.remove(key);
			capacityCounter--;
			System.out.println("Removed from cache key-val: " + key);
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache;
		String actions1 [] = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
		List<List<Integer>> values1 = Arrays.asList(Arrays.asList(2), Arrays.asList(1, 1), Arrays.asList(2, 2), Arrays.asList(1), Arrays.asList(3, 3), Arrays.asList(2), Arrays.asList(4, 4), Arrays.asList(1), Arrays.asList(3), Arrays.asList(4));
		cache = new LRUCache(values1.get(0).get(0));
		for ( int i = 1; i < actions1.length; i++ ) {
			String action = actions1[i];
			List<Integer> keyVal = values1.get(i);
			switch(action) {
				case "put":
					cache.put(keyVal.get(0), keyVal.get(1));
					break;
				case "get":
					System.out.println(cache.get(keyVal.get(0)));
					break;
				default:
					break;
			}
		}
		System.out.println("---------------------------------------------------------------------------");
		String actions2 [] = {"LRUCache","get","put","get","put","put","get","get"};
		List<List<Integer>> values2 = Arrays.asList(Arrays.asList(2), Arrays.asList(1), Arrays.asList(2, 6), Arrays.asList(1), Arrays.asList(1, 5), Arrays.asList(1,2), Arrays.asList(1), Arrays.asList(2));
		cache = new LRUCache(values2.get(0).get(0));
		for ( int i = 1; i < actions2.length; i++ ) {
			String action = actions2[i];
			List<Integer> keyVal = values2.get(i);
			switch(action) {
				case "put":
					cache.put(keyVal.get(0), keyVal.get(1));
					break;
				case "get":
					System.out.println(cache.get(keyVal.get(0)));
					break;
				default:
					break;
			}
		}
		
		System.out.println("---------------------------------------------------------------------------");
		String actions3 [] = {"LRUCache","put","put","put","put","get","get"};
		List<List<Integer>> values3 = Arrays.asList(Arrays.asList(2),Arrays.asList(2,1),Arrays.asList(1,1),Arrays.asList(2,3),Arrays.asList(4,1),Arrays.asList(1),Arrays.asList(2));
		cache = new LRUCache(values3.get(0).get(0));
		for ( int i = 1; i < actions3.length; i++ ) {
			String action = actions3[i];
			List<Integer> keyVal = values3.get(i);
			switch(action) {
				case "put":
					cache.put(keyVal.get(0), keyVal.get(1));
					break;
				case "get":
					System.out.println(cache.get(keyVal.get(0)));
					break;
				default:
					break;
			}
		}
	}

}
