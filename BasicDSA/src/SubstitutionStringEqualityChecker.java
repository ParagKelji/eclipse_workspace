
public class SubstitutionStringEqualityChecker {
	
	public boolean checkForEquality(String main, String secondary) {
		boolean isEqual = true;
		if ( main == null || "".equals(main) ) {
			return isEqual;
		}
		if ( secondary == null || "".equals(secondary) ) {
			return isEqual;
		}
		int tokensCount = secondary.length();
		for (int mainStringItr = 0, secondaryStringItr = 0; secondaryStringItr < tokensCount; ) {
			Character currToken = main.charAt(mainStringItr);
			Character currSecChar = secondary.charAt(secondaryStringItr);
			if (  Character.isDigit(currSecChar) ) {
				int secCount = Integer.parseInt(currSecChar.toString());
				secondaryStringItr++;
				mainStringItr += secCount;
			} else /*if ( Character.isAlphabetic(currSecChar) )*/ {
				// This else is if we also want to equate special characters, if not enable the above and the below block comment as well.
				if ( currToken.equals(secondary.charAt(secondaryStringItr)) ) {
					secondaryStringItr++;
					mainStringItr++;
					continue;
				} else {
					isEqual = false;
					break;
				}
			} 	/*
			 	 *  else { isEqual = false; break; }
			 	 */
		}
		return isEqual;
	}
	
	public static void main(String[] args) {
		SubstitutionStringEqualityChecker checker = new SubstitutionStringEqualityChecker();
		String m1 = "Mastercard";
		String s1 = "Masterca2";
		System.out.println(checker.checkForEquality(m1, s1));
		
		String m2 = "Mastercard";
		String s2 = "M5erca2";
		System.out.println(checker.checkForEquality(m2, s2));
		
		String m3 = "Mastercard";
		String s3 = "M5rca1";
		System.out.println(checker.checkForEquality(m3, s3));
		
	}

}
