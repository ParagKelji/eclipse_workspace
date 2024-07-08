package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedArrayRemoveDuplicates {
	
	private static final int LARGE_VAL = -10000;
	public int removeDuplicates(int[] nums) {
		int uniqueCount = 0;
		System.out.println("nums before : " + nums);
		for ( int i = 0; i < nums.length; i++ ) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println("");
		if ( nums == null || nums.length <= 0 ) {
			return uniqueCount;
		} else if ( nums.length == 1 ) {
			return 1;
		}
		for ( int i = 0; i < nums.length; i++ ) {
			for ( int j = i + 1; j < nums.length; j++ ) {
				if ( nums[i] == nums[j] ) {
					nums[j] = LARGE_VAL;
				}
			}
		}
		for ( int i = 0; i < nums.length; i++ ) {
			for ( int j = i + 1; j < nums.length; j++ ) {
				if (nums[i] == LARGE_VAL) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		for ( int i = 0; i < nums.length; i++ ) {
			if ( nums[i] != LARGE_VAL ) {
				uniqueCount++;
			}
		}
		System.out.println("nums after : " + nums);
		for ( int k = 0; k < nums.length; k++ ) {
			System.out.print(nums[k] + ", ");
		}
		System.out.println("");
		return uniqueCount;
    }
	public static void main(String[] args) {
		SortedArrayRemoveDuplicates sortedArrayRemoveDuplicates = new SortedArrayRemoveDuplicates();
		int [] nums = {0,0,1,1,1,2,2,3,3,4};
		int count = sortedArrayRemoveDuplicates.removeDuplicates(nums);
		System.out.println("Count of unique elements is: " + count);
	}

}