package medium;

import java.util.*;

public class ID_126_BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> preorder = new ArrayList<Integer> ();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			if(root != null) {
				stack.push(root);
			}
			while(!stack.isEmpty()) {
				root = stack.pop();
				preorder.add(root.val);
				if(root.right != null) {
					stack.push(root.right);
				}
				if(root.left != null) {
					stack.push(root.left);
				}
			}			
			return preorder;
			// recursive
			//	    	List<Integer> preorder = new ArrayList<Integer> ();
			//			if(root != null) {
			//				helper(root, preorder);
			//			}
			//			return preorder;
		}

		private void helper(TreeNode root, List<Integer> order) {
			order.add(root.val);
			if(root.left != null) {
				helper(root.left, order);
			}
			if(root.right != null) {
				helper(root.right, order);
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
