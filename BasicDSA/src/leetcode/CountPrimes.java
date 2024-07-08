package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

	public int countPrimes(int n) {
		if ( n <= 1 ) {
			return 0;
		}
		int[] primeNumbers = new int[n];
		for (int i = 2; i < primeNumbers.length; i++) {
			primeNumbers[i] = 1;
		}
		for (int i = 2; i * i <= n; i++) {
			if (primeNumbers[i] == 1) {
				for (int j = i * i; j < n; j += i) {
					primeNumbers[j] = 0;
				}
			}
		}
		int primeNumbersCount = 0;
		for (int i = 2; i < primeNumbers.length; i++) {
			if (primeNumbers[i] == 1) {
				primeNumbersCount++;
			}
		}
		return primeNumbersCount;
	}

	public static void main(String[] args) {
		CountPrimes countPrimes = new CountPrimes();
		System.out.println("Count Primes for n: " + countPrimes.countPrimes(10));
	}

}
