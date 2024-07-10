import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxSubArray {
	
	private static Map<String, Integer> sumsMap;
	
	public static void main(String[] args) {
		//Integer [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		Integer [] nums = {-2, -5, 6, -2, -3, 1, 5, -6};
		//{0_0=-2, 1_0=0, 1_1=-5, 2_2=6, 3_6=7}
		sumsMap = new TreeMap<String, Integer>();
		int maxSum = 0;
		int start = 0;
		/*int end = nums.length - 1;
		for ( int i = start; i <= end; i++ ) {
			int currSum = getMaxSum(nums, start, end);
			if ( currSum > maxSum ) {
				maxSum = currSum;
			}
		}*/
		/*maxSum = getMaxSum(nums);
		for (Map.Entry<String, Integer> entry : sumsMap.entrySet() ) {
			System.out.println("Key: " + entry.getKey() + " ==>> Value: " + entry.getValue());
		}*/
		maxSum = getMaxSumKadane(nums);
		System.out.println("maxSum: " + maxSum);
	}
		
	public static int getMax(int a, int b) {
		return Math.max(a, b);
	}
	
	public static int getMax(int a, int b, int c) {
		return getMax(getMax(a,b),c);
	}
	
	public static int getMaxSum(Integer [] nums, int start, int end) {
		System.out.println("Current Segment: " + start + " " + end);
		int maxSum = 0;
		if ( start == end ) {
			return nums[start];
		}
		int midpoint = (start + end) / 2;
		maxSum = getMax(
		getMaxSum(nums, start, midpoint),
		getMaxSum(nums, midpoint + 1, end),
		getMaxSub(nums, start, midpoint, end));
		System.out.println("Max sum " + maxSum);
		return maxSum;
	}
	
	public static int getMaxSub(Integer [] subNum, int start, int mid, int end) {
		System.out.println("For val: " + start + " " + mid + " " + end);
		String key = "";
		int sum = 0;
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		for ( int i = start; i <= mid; i++ ) {
			key += i;
			sum = sum + subNum[i];
		}
		if ( sum > leftSum ) {
			leftSum = sum;
			sumsMap.put(key, leftSum);
		} else {
			sumsMap.put(key, sum);
		}
		System.out.println("Left sum " + leftSum);
		key = "";
		sum = 0;
		for ( int i = mid + 1; i <= end; i++ ) {
			sum = sum + subNum[i];
		}
		if ( sum > rightSum ) {
			rightSum = sum;
			sumsMap.put(key, rightSum);
		} else {
			sumsMap.put(key, sum);
		}
		System.out.println("Right sum " + rightSum);
		System.out.println("Total : " + (leftSum + rightSum));
		return getMax(leftSum, rightSum,leftSum + rightSum);
	}
	
	public static int getMaxSum(Integer [] nums) {
		int maxSum = Integer.MIN_VALUE;
		int outerLoopCounter = 0;
		int innerLoopCounter = 0;
		for (int start = 0, end = 1;;) {
			outerLoopCounter++;
			int currSum = 0;
			System.out.println("start " + start + " end " + end);
			String key = start + "" + end;
			if ( !sumsMap.containsKey(key) ) {
				for (int i = start; i <= end; i++ ) {
					innerLoopCounter++;
					currSum += nums[i];
				}
				sumsMap.put(key, currSum);
			} else {
				currSum = sumsMap.get(key);
			}
			if ( currSum > maxSum ) {
				maxSum = currSum;
				currSum = 0;
			}
			if (end < nums.length - 1) {
				end++;
			} else {
				start++;
				end = start + 1;
			}
			if ( start == (nums.length - 1) ) {
				break;
			}
		}
		System.out.println("outerLoopCounter = " + outerLoopCounter + "	\ninnerLoopCounter = " + innerLoopCounter);
		return maxSum;
	}
	
	public static int getMaxSumKadane(Integer [] nums) {
		Map<String, Integer> sumsMap = new TreeMap<String, Integer>();
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		int start = 0;
		boolean currSumReset = false;
		for ( int i = 0; i < nums.length; i++ ) {
			currSum += nums[i];
			if ( currSum < 0 ) {
				currSumReset = true;
				String key = start + "_" + i;
				sumsMap.put(key, currSum);
				currSum = 0;
			}
			if ( currSum > maxSum ) {
				String key = start + "_" + i;
				sumsMap.put(key, currSum);
				maxSum = currSum;
			}
			if ( currSumReset ) {
				start = i + 1;
				currSumReset = false;
			}
		}
		return maxSum;
	}
}
