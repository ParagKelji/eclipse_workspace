package leetcode;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusOneArrayIntegerNum {
	
	public int[] plusOneNum(int[] digits) {
		String numStr = Arrays.toString(digits);
		Pattern p = Pattern.compile("[\\D]*");
		Matcher m = p.matcher(numStr);
		//numStr = Pattern.quote(numStr);
		numStr = m.replaceAll("");
		if ( digits == null || digits.length <= 0 ) {
			return digits;
		}
		System.out.println("numStr : " + numStr);
		long num = Long.parseLong(numStr);
		System.out.println("num : " + num);
		long numPlusOne = num + 1;
		String [] plusOneDigits = String.valueOf(numPlusOne).split("");
		digits = new int[plusOneDigits.length];
		for ( int i = 0; i < plusOneDigits.length; i++ ) {
			digits[i] = Integer.parseInt(plusOneDigits[i]);
		}
		return digits;
    }
	
	public int[] plusOne(int[] digits) {
		if ( digits == null || digits.length <= 0 ) {
			return digits;
		}
		int digiLen = digits.length;
		int firstDigit = digits[digiLen - 1];
		boolean firstDigit9 = false;
		boolean allDigits9 = true;
		if ( (digits[digiLen - 1] < 9) ) {
			digits[digiLen - 1] = firstDigit + 1;
			allDigits9 = false;
		} else {
			digits[digiLen - 1] = 0;
			firstDigit9 = true;
		}
		System.out.println("----------------------------------");
		System.out.println("firstDigit9 : " + firstDigit9);
		if ( firstDigit9 ) {
			for ( int i = digiLen - 2; i >= 0; i-- ) {
				int digit = digits[i];
				System.out.println("digits[" + i + "] : " + digit);
				if ( digit == 9 ) {
					digits[i] = 0;
				} else {
					allDigits9 = false;
					digits[i] = digit + 1;
					break;
				}
			}
		}
		System.out.println("----------------------------------");
		System.out.println("allDigits9 : " + allDigits9);
		System.out.println("----------------------------------");
		String numStr = Arrays.toString(digits);
		System.out.println(numStr);
		System.out.println("----------------------------------");
		if ( allDigits9 ) {
			int[] returnDigits = new int[digiLen + 1];
			returnDigits[0] = 1;
			returnDigits[1] = 0;
			for ( int i = 1; i < digiLen; i++ ) {
				returnDigits[i] = digits[i];
			}
			digits = returnDigits;
		}
		return digits;
	}
	
	public static void main(String[] args) {
		PlusOneArrayIntegerNum num = new PlusOneArrayIntegerNum();
		int [] digits1 = {9,9};
		int [] digits2 = {9,8,7,6,5,4,3,2,1,0};
		int [] digits3 = {9,9,9};
		int [] digits4 = {8,9,9,9};
		System.out.println("----------------------------------");
		String numStr = Arrays.toString(digits4);
		System.out.println(numStr);
		int [] newDigits = num.plusOne(digits4);
		System.out.println("----------------------------------");
		String numStrOut = Arrays.toString(newDigits);
		System.out.println(numStrOut);
	}

}
