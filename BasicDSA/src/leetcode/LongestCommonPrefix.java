package leetcode;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix1(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
	public String longestCommonPrefix(String[] strs) {
        int wordsCnt = 0;
        if ( strs != null ) {
        	wordsCnt = strs.length;
        }
        String prefix = strs[0];
        int shortestWordLen = (prefix != null ) ? prefix.length() : 0;;
        if ( wordsCnt > 1 ) {
	        for ( int i = 0; i < shortestWordLen; i++ ) {
	        	char fWChar = prefix.charAt(i);
	        	if ( shortestWordLen > 0 ) {
			        for ( int j = 1; j < wordsCnt; j++ ) {
			        	String currWord = strs[j];
			        	char cWChar = 0;
			        	if ( i < currWord.length() ) {
			        		cWChar = currWord.charAt(i);
			        	}
			        	if ( i == currWord.length() || cWChar != fWChar ) {
			        		return prefix.substring(0, i);
			        	}
			        }
		        }
	        }
        }
        return prefix;
    }
	
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		String[] strs1 = {"ab","a"};
		String[] strs2 = {"aaa","aa","aaa"};
		String[] strs3 = {"b","a",""};
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String prefix = longestCommonPrefix.longestCommonPrefix(strs3);
		System.out.println("Prefix : " + prefix);
		String prefix1 = longestCommonPrefix.longestCommonPrefix1(strs3);
		System.out.println("Prefix1 : " + prefix1);
	}

}
