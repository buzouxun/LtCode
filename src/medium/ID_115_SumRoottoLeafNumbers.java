package medium;

public class ID_115_SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int sumNumbers(TreeNode root) {
			int sum = 0;
			if(root == null) {
				// do nothing
			}
			else { 
				if(root.left == null && root.right == null) {
					sum += root.val;
				}
				else if(root.left != null && root.right == null){
					sum += helper(root.val, root.left);
				}
				else if(root.left == null && root.right != null){
					sum += helper(root.val, root.right);
				}
				else {
					sum += helper(root.val, root.left) + helper(root.val, root.right);
				}
			}
			return sum;
		}

		private int helper(int val, TreeNode root) {
			if(root.left == null && root.right == null) {
				return val * 10 + root.val;
			}
			else if(root.left != null && root.right == null){
				return helper(val * 10 + root.val, root.left);
			}
			else if(root.left == null && root.right != null){
				return helper(val * 10 + root.val, root.right);
			}
			else {
				
			}return helper(val * 10, root.left) + helper(val * 10, root.right);
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
