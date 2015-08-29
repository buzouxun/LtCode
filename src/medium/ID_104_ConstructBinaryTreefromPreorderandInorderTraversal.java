package medium;

import java.util.*;

public class ID_104_ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		ID_104_ConstructBinaryTreefromPreorderandInorderTraversal problem = new ID_104_ConstructBinaryTreefromPreorderandInorderTraversal();

		//		System.out.println(problem.new Solution().buildTree(new int[]{1,2,3}, new int[]{3,2,1}).left.left.val);
		//		System.out.println(problem.new Solution().buildTree(new int[]{1,2,3}, new int[]{1,2,3}).val);
		//		System.out.println(problem.new Solution().buildTree(new int[]{4,1,2,3}, new int[]{1,2,3,4}).left.right.right.val);
		//				System.out.println(problem.new Solution().buildTree(new int[]{2,1,3,4}, new int[]{1,2,3,4}).right.right.val);
		System.out.println(problem.new Solution().buildTree(new int[]{2,1,3,4}, new int[]{1,2,3,4}).val);
	}

	class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			TreeNode root = new TreeNode(preorder[0]);
			
			return root;

			// Myself
			//			if(preorder.length == 0 || inorder.length == 0) {
			//				return null;
			//			}
			//			else {
			//				TreeNode root = new TreeNode(preorder[0]);
			//				int pre = 1;
			//				for(pre = 1; pre < preorder.length; pre++) {
			//					int next = preorder[pre];
			//					int curr = preorder[0];
			//					boolean makeNew = false;
			//					TreeNode[] subTree = new TreeNode[1];
			//					TreeNode subRoot = root;
			//					while(makeNew == false) {
			//						// left or right
			//						int pos = findLeftOrRight(inorder, curr, next);
			//						// make new node
			//						int newNode = makeNewNode(subRoot, pos, curr, next, subTree);
			//						// if fail, try again
			//						if(newNode == next) {
			//							makeNew = true;
			//						}
			//						else {
			//							// fail
			//							curr = newNode;
			//							subRoot = subTree[0];
			//						}
			//					}
			//				}
			//				return root;
		}
	}

	private int makeNewNode(TreeNode root, int pos, int curr, int next, TreeNode[] subTree) {
		if(root.val == curr) {
			if(pos == -1) {
				// left
				if(root.left == null) {
					root.left = new TreeNode(next);
					return next;
				}
				else {
					subTree[0] = root.left;
					return root.left.val;
				}
			}
			else {
				// right
				if(root.right == null) {
					root.right = new TreeNode(next);
					return next;
				}
				else {
					subTree[0] = root.right;
					return root.right.val;
				}
			}
		}
		else {
			int found = curr;
			if(root.left == null && root.right == null) {
				found = curr;
			}
			else if(root.left != null && root.right == null) {
				found = makeNewNode(root.left, pos, curr, next, subTree);
			}
			else if(root.left == null && root.right != null) {
				found = makeNewNode(root.right, pos, curr, next, subTree);
			}
			else {
				found = makeNewNode(root.left, pos, curr, next, subTree);
				if(found != next) {
					found = makeNewNode(root.right, pos, curr, next, subTree);
				}
			}
			if(found != curr) {
				return found;
			}
			else {
				if(root.left != null && pos == -1) {
					return root.left.val;
				}
				else if(root.right != null && pos == 1) {
					return root.right.val;
				}
				else {
					return curr;
				}
			}
		}
	}

	private int findLeftOrRight(int[] array, int curr, int next) {
		int pos = 0;
		int curr_pos = -1;
		int next_pos = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == curr) {
				curr_pos = i;
			}
			if(array[i] == next) {
				next_pos = i;
			}
			if(curr_pos != -1 && next_pos != -1) {
				break;
			}	
		}
		if(next_pos < curr_pos) {
			// left
			pos = -1;
		}
		else {
			// right
			pos = 1;
		}
		return pos;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

}
