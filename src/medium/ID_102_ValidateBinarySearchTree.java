package medium;

import java.util.*;

public class ID_102_ValidateBinarySearchTree {

	public static void main(String[] args) {
		ID_102_ValidateBinarySearchTree problem = new ID_102_ValidateBinarySearchTree();
		
		TreeNode root = problem.new TreeNode(90);
		root.left = problem.new TreeNode(-75);
		root.right = problem.new TreeNode(3);
		root.left.left = problem.new TreeNode(-77);
		
		System.out.println(problem.new Solution().isValidBST(root));
	}

	class Solution {
		public boolean isValidBST(TreeNode root) {
			if(root == null) {
				return true;
			}
			boolean valid[] = new boolean[]{true};
			long[] min = new long[]{Long.MIN_VALUE};
			long[] max = new long[]{Long.MAX_VALUE};
			helper(root, valid, min, max);
			return valid[0];
		}

		private void helper(TreeNode root, boolean[] valid, long[] min, long[] max) {
			if(valid[0] == false) {
				return;
			}
			if(root == null) {
				return;
			}
			else {
				if(root.left == null && root.right == null) {

				}
				if(root.left != null) {
					if(root.left.val >= root.val || root.left.val <= min[0]) {
						valid[0] = false;
						return;
					}
				}
				if(root.right != null) {
					if(root.right.val <= root.val || root.right.val >= max[0]) {
						valid[0] = false;
						return;
					}
				}
				helper(root.left, valid, min, new long[]{root.val});
				helper(root.right, valid, new long[]{root.val}, max);
			}
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}	

}
