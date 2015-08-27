package medium;

import java.util.*;

public class ID_104_ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if(preorder.length == 0 || inorder.length == 0) {
				return null;
			}
			else {
				TreeNode root = new TreeNode(preorder[0]);
				int pre = 1;
				for(pre = 1; pre < preorder.length; pre++) {
					int next = preorder[pre];
					int curr = preorder[0];
					// left or right
					int pos = findLeftOrRight(inorder, curr, next);
					// make new node
					
					// if fail, try again
					
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
