package easy;

public class ID_47_CountPrimes {

	public static void main(String[] args) {
		ID_47_CountPrimes problem = new ID_47_CountPrimes();

		System.out.println("countPrimes(5) = " + problem.new Solution().countPrimes(6));
	}

	class Solution {
		public int countPrimes(int n) {
			int count = 0;
			// all numbers are prime, starting from 2
			boolean[] isNotPrime = new boolean[n + 1];	// false by default
			// find numbers which are not primes
			for(int i = 2; i * i <= n; i ++) {
				if (isNotPrime[i]) {
					// i is NOT  prime and do nothing
				}
				else {
					// i is prime; then multiples of i are Not primes
					for(int j = i * i; j < n;j += i) {
						isNotPrime[j] = true;
					}
				}
			}
			// count all numbers that are primes, starting from 2
			for(int k = 2; k < n; k++) {
				if(isNotPrime[k] == false) count++;
			}			
			return count;
		}
	}

}
