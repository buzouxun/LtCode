package medium;

import java.util.*;

public class ID_099_BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		ID_099_BinaryTreeInorderTraversal problem = new ID_099_BinaryTreeInorderTraversal();
		TreeNode test = problem.new TreeNode(1);
		test.right = problem.new TreeNode(2);
		test.right.left = problem.new TreeNode(3);

		System.out.println(problem.new Solution().inorderTraversal(test));
	}

	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> inorder = new ArrayList<Integer> ();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while(root != null || !stack.isEmpty()) {
				if(root != null) {
					stack.push(root);
					root = root.left;
				}
				else {
					root = stack.pop();
					inorder.add(root.val);
					root = root.right;
				}
			}
			return inorder;

			// recursive
			//			List<Integer> inorder = new ArrayList<Integer> ();
			//			if(root != null) {
			//				helper(root, inorder);
			//			}
			//			return inorder;
		}

		private void helper(TreeNode root, List<Integer> inorder) {
			if(root.left != null) {
				helper(root.left, inorder);
			}
			inorder.add(root.val);
			if(root.right != null) {
				helper(root.right, inorder);
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
