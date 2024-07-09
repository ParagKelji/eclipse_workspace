import java.util.HashMap;
import java.util.Map;

public class Palindrome {
	
	public boolean isPalindrome(String string) {
		boolean palindrome = true;
		Map<Integer, String> palindromesMap = new HashMap<>();
		if ( string == null || string == "" ) {
			return false;
		}
		int stringLength = string.length();
		int mid = 0;
		int start = 0;
		int end = 1;
		int low;
		int high;
		boolean odd;
		mid = stringLength / 2;
		if ( stringLength % 2 == 0 ) {
			odd = false;
		} else {
			odd = true;
		}
		if ( odd ) {
			for ( int i = mid - 1, j = mid + 1; i >= 0 || j < stringLength; i--, j++ ) {
				if ( Character.toLowerCase(string.charAt(i)) != Character.toLowerCase(string.charAt(j)) ) {
					palindrome = false;
					break;
				}
			}
		} else {
			for ( int i = (int) Math.floor(mid), j = (int) Math.ceil(mid); i >= 0 || j < stringLength; i--, j++ ) {
				if ( Character.toLowerCase(string.charAt(i)) != Character.toLowerCase(string.charAt(j)) ) {
					palindrome = false;
					break;
				}
			}
		}
		return palindrome;
	}

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		String string = "forgeeksskeegfor";
		boolean Palindrome = palindrome.isPalindrome(string);
		System.out.println(Palindrome);
		String string2 = "abababa";
		boolean Palindrome1 = palindrome.isPalindrome(string2);
		System.out.println(Palindrome1);
		String string3 = "aMALAYALAMa";
		boolean Palindrome2 = palindrome.isPalindrome(string3);
		System.out.println(Palindrome2);
		String string4 = "aMALA1ALAMa";
		boolean Palindrome3 = palindrome.isPalindrome(string4);
		System.out.println(Palindrome3);
	}

}
