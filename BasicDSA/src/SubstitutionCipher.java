
public class SubstitutionCipher {
	
	public String substitute(String input) {
		String output = "";
		if ( input == null || input == "" ) {
			return output;
		}
		char[] interimString = input.toCharArray();
		StringBuilder outBuilder = new StringBuilder();
		for (int i = 0; i < input.length(); i++ ) {
			Character currChar = interimString[i];
			int currCharVal = (int)currChar;
			int newVal = ( currChar != 'z' ) ? currCharVal + 1 : (int) 'a';
			char newChar = (char) newVal;
			outBuilder.append(newChar);
		}
		output = outBuilder.toString();
		return output;
	}
	
	public static void main(String[] args) {
		SubstitutionCipher cipher = new SubstitutionCipher();
		String s1 = "crazy";	
		System.out.println(cipher.substitute(s1));
		
	}

}
