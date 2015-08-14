package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID_077_PermutationSequence {

	public static void main(String[] args) {
		ID_077_PermutationSequence problem = new ID_077_PermutationSequence();

		//		System.out.println("ans = " + problem.new Solution().getPermutation(3, 6));
		System.out.println("ans = " + problem.new Solution().getPermutation(9, 273815));
	}

	class Solution {
		public String getPermutation(int n, int k) {
			k = k - 1;
			int factor = 1;
			for (int i = 1; i < n; i++) factor *= i;
			List<Integer> digits = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) digits.add(i + 1);
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				int index = k / factor;
				sb.append(digits.get(index));
				digits.remove(index); // remove used digit
				k = k % factor;
				if (i < n - 1) {
					factor = factor / (n - 1 - i);
				}
			}

			return sb.toString();
			/*
			char[] rawChoices = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
			char[] choices = Arrays.copyOfRange(rawChoices, 0, n);
			String kthPermutation = "";
			if(k == 0) {
				kthPermutation = String.valueOf(choices);
			}
			else if (k < 1) {

			}
			else {
				int[] numPermutation = new int[]{0};
				String permutation = "";
				String[] kthPermutationArray = new String[]{""};
				bt(choices, k, permutation, numPermutation, kthPermutationArray);
				kthPermutation = kthPermutationArray[0];
			}			
			return kthPermutation;
			 */
		}

		private void bt(char[] choices, int k, String permutation, int[] numPermutation, String[] kthPermutationArray) {
			// reject / accept
			if(choices.length == 0) {
				numPermutation[0] ++;
				//								System.out.println("kth = " + permutation);
				if(numPermutation[0] == k) {
					//					System.out.println("HAHAHA numPermutation = " + numPermutation[0]);
					//					System.out.println("HAHAHA permutation = " + permutation);
					kthPermutationArray[0] = new String(permutation);
					//					System.out.println("HAHAHA kthPermutation = " + kthPermutationArray[0]);
				}
				return;
			}
			// first
			int i = 0;
			while(i < choices.length) {
				if(numPermutation[0] > k) {
					break;
				}
				else {
					String new_permutation = permutation + String.valueOf(choices[i]);
					char[] new_choices = generateNewChoices(choices, i);
					bt(new_choices, k, new_permutation, numPermutation, kthPermutationArray);
					i ++;
				}
			}
		}

		private char[] generateNewChoices(char[] choices, int usedChoiceIndex) {
			char[] new_choices = new char[choices.length - 1];
			int j = 0;
			for(int i = 0; i < choices.length; i ++) {
				if(i == usedChoiceIndex) {
					// do nothing
				}
				else {
					new_choices[j] = choices[i];
					j ++ ;
				}
			}
			return new_choices;
		}
	}
}
