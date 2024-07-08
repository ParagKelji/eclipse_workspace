import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestWord {
	
	public static void main(String[] args) {
		//String sentence = "fun&!! time";
		String sentence = "I love dogs";
		Scanner s = new Scanner(System.in);
	    sentence = s.nextLine(); 
		getLongestWords(sentence);
	}
	
	public static List<String> getLongestWords(String sentence) {
		List<String> longestWords = new ArrayList<>();
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(sentence);
		List<String> words = new ArrayList<>();
		while (matcher.find()) {
			words.add(matcher.group());
		}
		TreeMap<Integer, List<String>> wordsLength = new TreeMap<>();
		for ( int i = 0; i < words.size(); i++ ) {
			String currWord = words.get(i);
			int currLength = currWord.length();
			if ( ! wordsLength.containsKey(currLength) ) {
				List<String> sameLenWords = new ArrayList<>();
				sameLenWords.add(currWord);
				wordsLength.put(currLength, sameLenWords);
			} else {
				List<String> sameLenWords = wordsLength.get(currLength);
				sameLenWords.add(currWord);
			}
		}
		longestWords = wordsLength.lastEntry().getValue();
		System.out.println("Longest words are with length: " + wordsLength.lastKey() + " and the words are: " + String.join(",", longestWords));
		return longestWords;
	}
	
	
}
