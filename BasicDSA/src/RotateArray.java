
public class RotateArray {
	
	public static void rotateArray(int[] nums, int steps) {
		if ( nums == null || nums.length <= 1 || steps == 0 ) {
			System.out.println("No change to the array.");
			return;
		}
		if ( steps == nums.length ) {
			return;
		}
		if ( steps > nums.length ) {
			steps -= nums.length;
		}
		int end = nums.length;
		int start = 0;
		int divisionPoint = -1;
		if ( steps > 0) {
			divisionPoint = Math.abs(end - steps);
		}  else if ( steps < 0 ) {
			divisionPoint = Math.abs(start - steps);
		}
		int [] arrayRight = new int[divisionPoint];
		int[] arrayLeft = new int[end - divisionPoint];
		for (int i = 0; i < divisionPoint; i++) {
			arrayRight[i] = nums[i];
		}
		for ( int i = divisionPoint; i < end; i++ ) {
			arrayLeft[i - divisionPoint] = nums[i];
		}
		System.arraycopy(arrayLeft, 0, nums, 0, arrayLeft.length);
		System.arraycopy(arrayRight, 0, nums, arrayLeft.length, arrayRight.length);
		/*
		 * for ( int i = 0, j = 0, k = 0; i <= end; i++ ) { if ( j < arrayLeft.length) {
		 * nums[i] = arrayLeft[j++]; } else if ( k < arrayRight.length) { nums[i] =
		 * arrayRight[k++]; } }
		 */
		String numStr = "";
		for ( int i = 0; i < end; i++ ) {
			numStr += nums[i] + " ";
		}
		System.out.println("Output Array: " + numStr);
	}
	
	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,6,7};
		int steps = 3;
		int [] nums2 = {-1,2};
		int steps2 = 2;
		//rotateArray(nums, steps);
		//rotateArray(nums2, steps2);
		int [] nums3 = {1,2,3};
		int steps3 = 5;
		rotateArray(nums3, steps3);
		
	}
}
