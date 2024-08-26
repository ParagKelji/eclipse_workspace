
// find out the pair  will give a sum of 100
// 30, 60, 20, 40, 90, 50, 10, 80, 70, 30, 70
import java.util.HashMap;
import java.util.Map;

public class AltimetricL2 {
	
	public void getSum100Pairs(Integer nums[]) {
		if ( nums == null || nums.length == 0 ) {
			return;
		}
		Map<Integer, Integer> pairs = new HashMap<>();
		int totalVals = nums.length;
		int sum = 0;
		for ( int i = 0; i < totalVals - 1; i++ ) {
			int currNum1 = nums[i];
			boolean isSumSuccessful = false;
			//sum += currNum;
			for ( int j = i; j < totalVals; j++ ) {
				int currNum2 = nums[j];
				if ( i != j ) {
					sum = currNum1 + currNum2;
				}
				if ( sum == 100 ) {
					isSumSuccessful = true;
					System.out.println("Nums responsible for 100: " + currNum1 + ", " + currNum2);
					sum = 0;
					break;
				}
			}
			// May not need the below unless some additional mod is needed in case of isSumSuccessful = false.
			if ( isSumSuccessful ) {
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		AltimetricL2 test = new AltimetricL2();
		Integer nums[] = {30, 60, 20, 40, 90, 50, 10, 80, 70, 30, 70};
		
		test.getSum100Pairs(nums);
	}

}
