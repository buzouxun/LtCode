package medium;

import java.util.*;

import org.omg.CORBA.TRANSACTION_MODE;

public class ID_111_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int minimumTotal(List<List<Integer>> triangle) {
			int[] array = new int[triangle.size() + 1];
			// 4, 3, 2, 1
			for(int i = triangle.size(); i >= 1; i--) {
				// 4, 3, 2, 1
				for(int j = 0; j < triangle.get(i - 1).size(); j++) {
					array[j] = Math.min(array[j], array[j+1]) + triangle.get(i-1).get(j);					
				}
			}			
			return array[0];
		}
	}
}
