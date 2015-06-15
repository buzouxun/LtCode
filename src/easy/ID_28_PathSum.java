package easy;

public class ID_28_PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public boolean hasPathSum(TreeNode root, int sum) {
			boolean equal = false;
			int tmpSum = 0;	
			if(root == null) {
				// do nothing
			}
			else {
				equal = pathSumEqual(root, sum, tmpSum);	
			}
			return equal;
		}
		private boolean pathSumEqual(TreeNode root, int target, int tmpSum) {
			boolean equal = false;
			tmpSum += root.val;
			if(root.left == null && root.right == null) {
				if(tmpSum == target) {
					equal = true;
				}
			}
			else if (root.left == null){
				equal = equal || pathSumEqual(root.right, target, tmpSum);
			}		
			else if (root.right == null){
				equal = equal || pathSumEqual(root.left, target, tmpSum);
			}	
			else {
				equal = equal || pathSumEqual(root.left, target, tmpSum) || pathSumEqual(root.right, target, tmpSum);
			}	
			return equal;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
