package leetcode;

public class LongestUniqCharsSubstr {
	
	public int lengthOfLongestSubstring(String s) {
        int len = 0;
        if ( s == null || s == "" ) {
        	return len;
        }
        int strLen = s.length();
        String maxUniqS = "";
        char prevChar = '\000';
        for ( int i = 0; i < strLen; i++ ) {
        	char currChar;
        	currChar = s.charAt(i);
        	if ( maxUniqS.indexOf(currChar) == -1 ) {
        		maxUniqS += currChar;
        	} else {
        		int oldIdx = maxUniqS.indexOf(currChar);
        		maxUniqS =  maxUniqS.substring(oldIdx + 1, maxUniqS.length()) + currChar;
        	}
        	if ( len < maxUniqS.length() ) {
        		len = maxUniqS.length();
        	}
        	prevChar = currChar;
        }
        return len;
    }
	public static void main(String[] args) {
		LongestUniqCharsSubstr uniqSubStr = new LongestUniqCharsSubstr();
		String s1 = "abcabcbb";
		//System.out.println(uniqSubStr.lengthOfLongestSubstring(s1));
		String s2 = "bbbbb";
		//System.out.println(uniqSubStr.lengthOfLongestSubstring(s2));
		String s3 = "pwwkew";
		//System.out.println(uniqSubStr.lengthOfLongestSubstring(s3));
		String s4 = "aab";
		//System.out.println(uniqSubStr.lengthOfLongestSubstring(s4));
		String s5 = "dadf";
		//System.out.println(uniqSubStr.lengthOfLongestSubstring(s5));
		String s6 = "aabaab!bb";
		System.out.println(uniqSubStr.lengthOfLongestSubstring(s6));
	}

}
