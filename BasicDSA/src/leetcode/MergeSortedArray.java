package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if ( nums1 == null ) {
			nums1 = nums2;
		}
		if ( nums2 == null ) {
			return;
		}
		int index1 = 0;
		int index2 = 0;
		for ( index1 = m; index1 < (m + n); index1++ ) {
			nums1[index1] = nums2[index2++];
		}
		Arrays.sort(nums1);
		
    }
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		if ( nums1 == null ) {
			nums1 = nums2;
		}
		if ( nums2 == null ) {
			return;
		}
		TreeMap<Integer, Integer> nums = new TreeMap<>();
		int index1 = 0;
		int index2 = 0;
		for ( index1 = 0; index1 < m; index1++ ) {
			int num = nums1[index1];
			if ( nums.containsKey(num) ) {
				nums.put(num, nums.get(num) + 1);
			} else {
				nums.put(num, 1);
			}
		}
		for ( index2 = 0; index2 < n; index2++ ) {
			int num = nums2[index2];
			if ( nums.containsKey(num) ) {
				nums.put(num, nums.get(num) + 1);
			} else {
				nums.put(num, 1);
			}
		}
		index1 = 0;
		for ( Map.Entry<Integer, Integer> keys : nums.entrySet() ) {
			int value = keys.getKey();
			int freq = keys.getValue();
			for ( int i = 0; i < freq; i++ ) {
				nums1[index1++] = value;
			}
		}
		
    }
	public static void main(String[] args) {
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int [] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int [] nums2 = {2,5,6};
		int n = 3;
		mergeSortedArray.merge1(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}

}
