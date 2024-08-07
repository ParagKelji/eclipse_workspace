package leetcode;

import java.util.HashMap;
import java.util.Map;

public class HIndex {
	
	public static int calculateHIndex(int[] citations) {
		int numPapers = citations.length;
        int[] citationCounts = new int[numPapers + 1];
        for (int citation : citations) {
            if (citation >= numPapers) {
                citationCounts[numPapers]++;
            } else {
                citationCounts[citation]++;
            }
        }
        int cumulativePapers = 0;
        for (int hIndex = numPapers; hIndex >= 0; hIndex--) {
            cumulativePapers += citationCounts[hIndex];
            if (cumulativePapers >= hIndex) {
                return hIndex;
            }
        }
        return 0;
	}
	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(calculateHIndex(citations));
	}

}
