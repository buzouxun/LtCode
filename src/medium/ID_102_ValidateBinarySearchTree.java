package medium;

import java.util.*;

public class ID_102_ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public boolean isValidBST(TreeNode root) {
			boolean valid[] = new boolean[]{true};
			helper(root, valid);
			return valid[0];
		}

		private void helper(TreeNode root, boolean[] valid) {
			
			
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}	

}
