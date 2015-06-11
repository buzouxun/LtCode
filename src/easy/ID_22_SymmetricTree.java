package easy;

public class ID_22_SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {

		public boolean isSymmetric(TreeNode root) {
			boolean symmetric = true;
			if(root == null) {
				// do nothing
			}
			else {
				symmetric = symmetric && isSymmetricHelper(root.left, root.right);
			}			
			return symmetric;
		}

		private boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {
			boolean symmetric = true;
			if(node1 == null && node2 == null) {
				// do nothing
			}
			else if(node1 != null && node2 == null) {
				symmetric = false;
			}
			else if(node1 == null && node2 != null) {
				symmetric = false;
			}
			else if(node1.val != node2.val){
				symmetric = false;
			}
			else {
				symmetric = isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
			}
			return symmetric;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
