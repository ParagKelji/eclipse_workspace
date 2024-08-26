import java.util.HashMap;
import java.util.Map;

public class ArraysOverlappingSum {
	
	public int getOverlappingSum(int [] array1, int [] array2 ) {
		int overlappingSum = 0;
		HashMap<Integer, Integer> mapOfOverlap = new HashMap<>();
		if ( array1 == null || array2 == null ) {
			return overlappingSum;
		}
		if ( array1.length == 0 || array2.length == 0 ) {
			return overlappingSum;
		}
		for ( int i = 0; i < array1.length; i++ ) {
			int num1 = array1[i];
			if ( !mapOfOverlap.containsKey(num1) ) {
				mapOfOverlap.put(num1, 1);
			}
		}
		for ( int i = 0; i < array2.length; i++ ) {
			int num1 = array2[i];
			if ( !mapOfOverlap.containsKey(num1) ) {
				mapOfOverlap.put(num1, 1);
			} else {
				int val = mapOfOverlap.get(num1);
				mapOfOverlap.put(num1, ++val);
			}
		}
		for ( Map.Entry<Integer, Integer> entryMap : mapOfOverlap.entrySet() ) {
			int key = entryMap.getKey();
			int value = entryMap.getValue();
			if ( value > 1 ) {
				overlappingSum += (key * value);
			}
		}
		return overlappingSum;
	}

	public static void main(String[] args) {
		ArraysOverlappingSum summingMachine = new ArraysOverlappingSum();
		int A1[] = {1, 5, 3, 8};
        int B1[] = {5, 4, 6, 7};
        System.out.println(summingMachine.getOverlappingSum(A1, B1));
		int A2[] = {1, 5, 3, 8};
        int B2[] = {5, 1, 8, 3};
        System.out.println(summingMachine.getOverlappingSum(A2, B2));
	}

}
