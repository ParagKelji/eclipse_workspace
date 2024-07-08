package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		int count = 0;
		int candidate = 0;
		if ( nums == null || nums.length <= 0 ) {
			return candidate;
		}
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for ( int i = 0 ; i < nums.length; i++ ) {
			int num = nums[i];
			if (counts.containsKey(num)) {
				counts.put(num, counts.get(num) + 1);
			} else {
				counts.put(num, 1);
			}
			if (counts.get(num) > count) {
				count = counts.get(num);
				candidate = num;
			}
		}
		return candidate;
	}
	
	public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		int [] nums = {3,2,3};
		System.out.println(majorityElement.majorityElement(nums));
	}

}
