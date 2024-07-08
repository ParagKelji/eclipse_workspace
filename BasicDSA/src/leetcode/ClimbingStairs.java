package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ClimbingStairs {
	
	public int climbStairs(int n) {
		if ( n == 0 ) {
			return 0;
		}
		int one = 1;
		int two = 1;
		for (int i = 1; i < n ; i++ ) {
			System.out.println("One : " + one + " , two : " + two);
			int temp = one;
			one = one + two;
			two = temp;
		}
		System.out.println("waysToClimb : " + one);
		return one;
    }

	public static void main(String[] args) {
		int stairCount = 8;
		ClimbingStairs climbingStairs = new ClimbingStairs();
		int ways = climbingStairs.climbStairs(stairCount);
		System.out.println("Ways: " + ways);
	}

}
