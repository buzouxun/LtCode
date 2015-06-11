package easy;

public class ID_26_BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public boolean isBalanced(TreeNode root) {
			boolean balanced = true;
			if(root == null) {
				// do nothing
			}
			else {
				if(Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) > 1) {
					balanced = false;
				}
				else {
					balanced = isBalanced(root.left) && isBalanced(root.right);
				}
			}
			return balanced;
		}
		
		private int getMaxDepth(TreeNode node) {
			int depth = -1;
			if(node == null) {
				depth = 0;
			}
			else {
				depth = Math.max(getMaxDepth(node.left) + 1, getMaxDepth(node.right) + 1);
			}
			return depth;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
