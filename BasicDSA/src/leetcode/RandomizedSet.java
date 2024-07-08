package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

	private Map<Integer, Integer> map;
	private List<Integer> list;
	private int size;
	
	public RandomizedSet() {
		this.map = new HashMap<Integer, Integer>();
		this.list = new ArrayList<Integer>();
		this.size = 0;
	}
    public boolean insert(int val) {
    	boolean added = false;
    	if ( !map.containsKey(val) ) {
    		map.put(val,size);
			list.add(val);
    		size++;
    		added = true;
    	}
    	return added;
    }
    
    public boolean remove(int val) {
    	if ( !map.containsKey(val) ) {
			return false;
		}
		int index = map.get(val);
		map.remove(val);
		if ( index != size-1 ) {
			list.set(index, list.get(size-1));
			map.put(list.get(index), index);
		}
		list.remove(size-1);
		size--;
    	return true;
    }
    
    public int getRandom() {
    	if ( size > 0 ) {
			return list.get((int)(Math.random()*size) );
		}
    	return 0;
    }
    
	public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		/*
		 * System.out.println(set.insert(1)); System.out.println(set.remove(2));
		 * //System.out.println(set.getRandom()); System.out.println(set.insert(2));
		 * System.out.println(set.getRandom()); System.out.println(set.remove(1));
		 * System.out.println(set.insert(2)); System.out.println(set.getRandom());
		 */
		
		System.out.println(set.insert(0));
		System.out.println(set.remove(0));
		System.out.println(set.insert(-1));
		System.out.println(set.remove(0));
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
	}

}
