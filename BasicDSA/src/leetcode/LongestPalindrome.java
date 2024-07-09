package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

	public String getLongestPalindrome(String string) {
		String longestPalindrome = "";
		Map<Integer, String> palindromesMap = new HashMap<>();
		if ( string == null || string == "" ) {
			return longestPalindrome;
		}
		int stringLength = string.length();
		int mid = 0;
		int start = 0;
		int end = 1;
		int low;
		int high;
		boolean odd;
		if ( stringLength % 2 == 0 ) {
			mid = stringLength / 2;
			odd = false;
		} else {
			mid = (stringLength - 1) / 2;
			odd = true;
		}
		
		for ( int i = 0; i < stringLength; i++ ) {
			low = i - 1;
			high = i;
			while ( low >= 0 && high < stringLength && Character.toLowerCase(string.charAt(low)) == Character.toLowerCase(string.charAt(high)) ) {
				// Update maximum length and starting index
                if ( high - low + 1 > end ) {
                    start = low;
                    end = high - low + 1;
                }
                low--;
                high++;
			}
			
			// Find longest palindromic substring of odd size
            low = i - 1;
            high = i + 1;

            // Expand substring while it is palindrome and in bounds
            while ( low >= 0 && high < stringLength && Character.toLowerCase(string.charAt(low)) == Character.toLowerCase(string.charAt(high)) ) {

                // Update maximum length and starting index
                if ( high - low + 1 > end ) {
                    start = low;
                    end = high - low + 1;
                }
                low--;
                high++;
            }
		}
		longestPalindrome = string.substring(start, start + end);
		return longestPalindrome;
	}

	public static void main(String[] args) {
		LongestPalindrome palindrome = new LongestPalindrome();
		String string = "forgeeksskeegfor";
		String string2 = "abababa";
		String string3 = "aMALAYALAMa";
		String string4 = "aMALA1ALAMa";
		String longestPalindrome = palindrome.getLongestPalindrome(string4);
		System.out.println(longestPalindrome);
	}
	
}
