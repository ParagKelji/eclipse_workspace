package leetcode;

import java.util.Stack;

public class ValidParenthesis {
	
	public boolean isValid(String s) {
        boolean parenthesisAreValid = false;
        Stack<Character> parenthesisParser = new Stack<>();
        if ( s == null || s.length() < 2 ) {
        	return parenthesisAreValid;
        }
        for (int i = 0; i < s.length(); i++) {
        	Character currChar = s.charAt(i);
        	switch (currChar) {
				case '(':
				case '[':
				case '{':
					parenthesisParser.push(currChar);
					break;
				case ')':
					if ( parenthesisParser.isEmpty() ) {
						return parenthesisAreValid;
					}
					Character topChar1 = parenthesisParser.peek();
					if ( topChar1 == '(' ) {
						parenthesisParser.pop();
					} else {
						return parenthesisAreValid;
					}
					break;
				case ']':
					if ( parenthesisParser.isEmpty() ) {
						return parenthesisAreValid;
					}
					Character topChar2 = parenthesisParser.peek();
					if ( topChar2 == '[' ) {
						parenthesisParser.pop();
					} else {
						return parenthesisAreValid;
					}
					break;
				case '}':
					if ( parenthesisParser.isEmpty() ) {
						return parenthesisAreValid;
					}
					Character topChar3 = parenthesisParser.peek();
					if ( topChar3 == '{' ) {
						parenthesisParser.pop();
					} else {
						return parenthesisAreValid;
					}
					break;
				default:
					break;
			}
        }
        if ( parenthesisParser.isEmpty() ) {
        	parenthesisAreValid = true;
        }
		return parenthesisAreValid;
    }

	public static void main(String[] args) {
		ValidParenthesis parenthesis = new ValidParenthesis();
		String s1 = "(])";
		String s2 = "(())([]{})";
		String s3 = "(]";
		String s4 = "([])";
		boolean parenthesisAreValid1 = parenthesis.isValid(s1);
		System.out.println(s1 + " parenthesisAreValid1 " + parenthesisAreValid1);
		/*boolean parenthesisAreValid2 = parenthesis.isValid(s2);
		System.out.println(s2 + " parenthesisAreValid2 " + parenthesisAreValid2);
		boolean parenthesisAreValid3 = parenthesis.isValid(s3);
		System.out.println(s3 + " parenthesisAreValid3 " + parenthesisAreValid3);
		boolean parenthesisAreValid4 = parenthesis.isValid(s4);
		System.out.println(s4 + " parenthesisAreValid4 " + parenthesisAreValid4);*/
	}

}
