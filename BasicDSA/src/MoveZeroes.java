import java.util.HashMap;
import java.util.Map;

public class MoveZeroes {
	public static void main(String[] args) {
		Integer[] numbers = {1,0,0,3,12};
		moveZeroes(numbers);
	}
	
	public static void moveZeroes(Integer [] numbers) {
		Map<Integer, Integer> arrayMap = new HashMap<>();
		System.out.println("OG Array: " + arrayToString(numbers));
		int j = 0;
		/*for ( int i = 0; i < numbers.length; i++ ) {
			if (numbers[i] != 0) {
				numbers[j++] = numbers[i];
			}
		}
		System.out.println("Array at the end of Loop 1: " + arrayToString(numbers));*/
		for ( int i = 0; i < numbers.length; i++ ) {
			int num1 = numbers[i];
			System.out.println("Num1[" + i + "]: " + num1);
			//arrayMap.put(i, num1);
			int num2 = numbers[j];
			
			System.out.println("Num2[" + j + "]: " + num2);
			if ( num1 != 0 ) {
				if ( i != j ) {
					numbers[j] = num1;
					numbers[i] = num2;
				}
				j++;
			}
			System.out.println("Array at the end of pass" + i + ": " + arrayToString(numbers));
		}
		System.out.println("Array at the end: " + arrayToString(numbers));
	}
	
	public static String arrayToString(Integer [] array) {
		String str = "";
		for (int i = 0; i < array.length; i++ ) {
			str += array[i] + " ";
		}
		return str;
	}
}
