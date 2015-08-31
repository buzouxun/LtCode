package medium;

public class ID_109_FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		ID_109_FlattenBinaryTreetoLinkedList problem = new ID_109_FlattenBinaryTreetoLinkedList();

		TreeNode root = problem.new TreeNode(1);
		root.left = problem.new TreeNode(2);
		System.out.println(root.left.val);
		problem.new Solution().flatten(root);
		System.out.println(root.right.val);
	}

	class Solution {
		
		TreeNode root2ForRight;

		//   1       1
		//  2 3        2
		//               3
		public void flatten(TreeNode root) {
			if(root == null) {

			}
			else {
				//				TreeNode newRoot = root;
				TreeNode[] rootForRight = new TreeNode[]{new TreeNode(-1)};
				root2ForRight = root;
				root = helper2(root);
			}			
		}
		
		private TreeNode helper2(TreeNode root) {
			if(root == null) {
				// do nothing
			}
			else {
				TreeNode oldLeft = root.left;
				TreeNode oldRight = root.right;
				TreeNode newLeft = helper2(oldLeft);
				if(newLeft == null) {
					root2ForRight = root;
				}
				else {
					root.right = newLeft;
				}
				TreeNode tmpRootForRight = root2ForRight;
				TreeNode newRight = helper2(oldRight);
				if(newRight == null) {
					root2ForRight = root;
				}
				else {
					tmpRootForRight.right = newRight;
				}
			}
			return root;
		}

		private TreeNode helper(TreeNode root, TreeNode[] rootForRight) {
			if(root == null) {
				// do nothing
			}
			else {
				TreeNode oldLeft = root.left;
				TreeNode oldRight = root.right;
				TreeNode newLeft = helper(oldLeft, rootForRight);
				if(newLeft == null) {
					rootForRight[0] = root;
				}
				else {
					root.right = newLeft;
				}
				TreeNode tmpRootForRight = rootForRight[0];
				TreeNode newRight = helper(oldRight, rootForRight);
				if(newRight == null) {
					rootForRight[0] = root;
				}
				else {
					tmpRootForRight.right = newRight;
				}
			}
			return root;
		}

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
