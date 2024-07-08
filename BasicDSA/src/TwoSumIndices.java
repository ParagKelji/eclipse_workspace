import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIndices {

	public static void main(String[] args) {
		
		/*List<Integer> numbers = new ArrayList<>();
		numbers.add(2)
		*/
		Integer [] numbers = {2,5,5,11};
		int sum = 7;
		Map<Integer, Integer> indices = getIndexWhichSumsTo(numbers, sum);
		System.out.println("Indices are: " + indices);
	}
	
	public static Map<Integer, Integer> getIndexWhichSumsTo(Integer [] numbers, int sum) {
		Map<Integer, Integer> indices = new HashMap<>();
		Map<Integer, Integer> arrayMap = new HashMap<>();
		if ( numbers == null || numbers.length == 0 ) {
			return indices;
		}
		for (int i = 0; i < numbers.length; i++) {
			int num1 = numbers[i];
			arrayMap.put(num1, i);
		}
		System.out.println("ArrayMap: " + arrayMap);
		for (int i = 0; i < numbers.length - 1; i++) {
			int num1 = numbers[i];
			int num2 = sum - num1;
			if ( arrayMap.containsKey(num2) ) {
				int j = arrayMap.get(num2);
				if ( !(indices.containsKey(i) || indices.containsKey(j)) ) {
					indices.put(i, j);
				}
			}		
		}
		return indices;
	}
}
