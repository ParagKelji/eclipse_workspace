
public class LargestOddNumberInString {

	public static void main(String[] args) {
		String str = "This string of numbers 1&23&35456";
		System.out.println("Largest odd number: " + largestOddNumber(str));
	}
	
	public static String largestOddNumber(String str) {
		String largest = "";
		if (str == null || !str.matches(".*\\d.*")) {
			return null;
		}
		String currNum = "";
		for (int i = 0; i < str.length(); i++) {
			Character currChar = str.charAt(i);
			if ( !Character.isDigit(currChar) ) {
				continue;
			}
			currNum += str.substring(i, i + 1);
			if (i + 1 < str.length()) {
				Character nextChar = str.charAt(i + 1);
				if ( !Character.isDigit(nextChar) ) {
					largest = assignCurrentLargestOddNum(largest, currNum);
					currNum = "";
					continue;
				}
			} else {
				largest = assignCurrentLargestOddNum(largest, currNum);
				continue;
			}
		}
		return largest;
	}

	private static String assignCurrentLargestOddNum(String largest, String currNum) {
		String currLargest;
		int num = Integer.parseInt(currNum);
		if (num % 2 != 0) {
			currLargest = currNum;
			if (currLargest.length() > largest.length()) {
				largest = currLargest;
			}
		}
		return largest;
	}

}
