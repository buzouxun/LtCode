package medium;

import java.util.*;

import org.omg.CORBA.TRANSACTION_MODE;

public class ID_111_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int minimumTotal(List<List<Integer>> triangle) {
			int[] rows = new int[triangle.size()];
			for(int i = 1; i < triangle.size(); i++) {
				for(int j = 0; j < triangle.get(i).size(); j++) {
					
				}
			}			
			return rows[triangle.size() - 1];
		}

	}
}
