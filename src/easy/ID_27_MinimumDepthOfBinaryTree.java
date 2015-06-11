package easy;

public class ID_27_MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int minDepth(TreeNode root) {
			int depth = 1;
			if(root == null) {
				depth = 0;
			}
			else {
				if(root.left == null && root.right == null) {
					// do nothing
				}
				else if(root.left == null) {
					depth += minDepth(root.right);
				}
				else if(root.right == null) {
					depth += minDepth(root.left);
				}
				else {
					depth += Math.min(minDepth(root.left), minDepth(root.right));
				}
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
