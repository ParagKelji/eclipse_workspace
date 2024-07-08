import java.util.HashMap;
import java.util.Map;

public class ArrayDuplicates {
	
	public static void main(String[] args) {
		Integer [] nums = {1,4,3,2};
		System.out.println(containsDuplicates(nums));
	}
	
	public static boolean containsDuplicates(Integer [] nums) {
		boolean hasDuplicate = false;
		Map<Integer, Boolean> itemCheck = new HashMap<>();
		if (nums == null || nums.length == 0) {
			return hasDuplicate;
		}
		for (int i = 0; i < nums.length; i++ ) {
			if ( !itemCheck.containsKey(nums[i]) ) {
				itemCheck.put(nums[i], true);
			} else {
				hasDuplicate = true;
				break;
			}
		}
		return hasDuplicate;
	}
}
