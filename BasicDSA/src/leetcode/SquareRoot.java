package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SquareRoot {
	
	public static List<Integer> primeNumbers = new ArrayList<Integer>();
	{
		//19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
		primeNumbers.add(2);
		primeNumbers.add(3);
		primeNumbers.add(5);
		primeNumbers.add(7);
		primeNumbers.add(9);
		primeNumbers.add(11);
		primeNumbers.add(13);
		primeNumbers.add(19);
		primeNumbers.add(23);
		primeNumbers.add(29);
		primeNumbers.add(31);
		primeNumbers.add(37);
		primeNumbers.add(41);
		primeNumbers.add(43);
		primeNumbers.add(47);
		primeNumbers.add(53);
		primeNumbers.add(59);
		primeNumbers.add(61);
		primeNumbers.add(71);
		primeNumbers.add(73);
		primeNumbers.add(79);
		primeNumbers.add(79);
		primeNumbers.add(83);
		primeNumbers.add(89);
		primeNumbers.add(97);
		primeNumbers.add(101);
		primeNumbers.add(103);
	}
	
	public int mySqrt1(int x) {
		/*x = sqRt * sqRt;
		sqRt = x/sqRt;*/
		if ( x == 0 ) {
			return 0;
		}
		if ( x == 1 ) {
			return 1;
		}
		List<Integer> primeFactors = new ArrayList<>();
		int i = 0;
		int dividend = x;
		while ( i <= (primeNumbers.size() - 1) ) {
			int primeFactor = primeNumbers.get(i);
			System.out.println("Dividend : " + dividend);
			System.out.println("primeFactor : " + primeFactor);
			int remainder = dividend % primeFactor;
			System.out.println("Remainder : " + remainder);
			int quotient = dividend/primeFactor;
			System.out.println("Quotient : " + quotient);
			dividend = quotient;
			if ( remainder >= 0 ) {
				primeFactors.add(primeFactor);
			} else {
				i++;
			}
			if ( quotient == 1 ) {
				break;
			}
		}
		int multiplier = 1;
		if ( primeFactors.size() % 2 == 0 ) {
			for (int j = 0; j < primeFactors.size(); j += 2 ) {
				multiplier *= primeFactors.get(i);
			}
		} else {
			for (int j = 0; j < primeFactors.size() - 1; j += 2 ) {
				multiplier *= primeFactors.get(i);
			}
			//multiplier *= primeFactors.get(primeFactors.size() - 1);
		}
		
		return multiplier;
    }

    public int mySqrt(int x) {
        if(x <= 1) return x;
        int start = 1;
        int end = x/2;
        
        while(start < end) {
            int mid = (start + (end-start)/2) + 1;
            System.out.println("mid : " + mid);
            int div = x/mid;
            if(div == mid) return mid;
            if(div > mid) { 
            	start = mid;
            } else {
            	end = mid-1;
            }
            System.out.println("start : " + start);
            System.out.println("mid : " + mid);
        }
        
        return start;
    }
    
	public static void main(String[] args) {
		SquareRoot squareRoot = new SquareRoot();
		int num1 = 5;
		int sqRt = squareRoot.mySqrt(num1);
		System.out.println("Square root of " + num1 + " = " + sqRt);
	}

}
