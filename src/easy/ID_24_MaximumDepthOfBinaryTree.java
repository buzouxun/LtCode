package easy;

public class ID_24_MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

	class Solution {
		public int maxDepth(TreeNode root) {
			int depth = 0;
			if(root == null) {
				depth = 0;
			}
			else {
				depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
