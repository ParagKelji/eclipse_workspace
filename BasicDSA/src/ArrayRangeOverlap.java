import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayRangeOverlap {
	
	public boolean isMinimalOverlap(int [] array) {
		boolean minimalOverlap = false;
		if (array == null || array.length != 5 ) {
			return minimalOverlap;
		}
		int range1Start = array[0];
		int range1End = array[1];
		int range2Start = array[2];
		int range2End = array[3];
		long minimumOverlap = array[4];
		long overlap = 0;
		
		int lowest = array[0];
		int max = 0;
		for ( int i = 0; i < array.length - 1; i++ ) {
			lowest = Math.min(array[i], lowest);
			max = Math.max(array[i], max);
		}
		int [] overlapRange = new int[max];
		for (int i = 0; i < max; i++ ) {
			overlapRange[i] = 0;
			if ( fallsInRange(i, range2Start, range2End) && fallsInRange(i, range1Start, range1End) ) {
				overlapRange[i] = 1;
			}
		}
		IntStream stream = Arrays.stream(overlapRange);
		overlap = stream.sum();
		if ( overlap >= minimumOverlap ) {
			minimalOverlap = true;
		}
		return minimalOverlap;
	}

	private boolean fallsInRange(int num, int start, int end) {
		if ( num >= start && num <= end ) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ArrayRangeOverlap rangeOverlap = new ArrayRangeOverlap();
		int [] array1 = {4, 10, 2, 6, 3}; 	//	true
		System.out.println(rangeOverlap.isMinimalOverlap(array1));
		int [] array2 = {2, 6, 4, 10, 3}; 	//	true
		System.out.println(rangeOverlap.isMinimalOverlap(array2));
		int [] array3 = {2, 6, 4, 10, 4}; 	//	false
		System.out.println(rangeOverlap.isMinimalOverlap(array3));
		int [] array4 = {2, 6, 4, 10}; 	//	false
		System.out.println(rangeOverlap.isMinimalOverlap(array4));
		int [] array5 = {2, 6, 1, 10, 5}; 	//	true
		System.out.println(rangeOverlap.isMinimalOverlap(array5));
		int [] array6 = {2, 6, 1, 10, 6}; 	//	false
		System.out.println(rangeOverlap.isMinimalOverlap(array6));
		int [] array7 = {4, 10, 2, 6, 4}; 	//	false
		System.out.println(rangeOverlap.isMinimalOverlap(array7));
		
	}
}
