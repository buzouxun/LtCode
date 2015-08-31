package medium;

import java.util.Arrays;

public class ID_105_ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	    	if(inorder.length == 0 && postorder.length == 0) {
	    		return null;
	    	}
	    	if(inorder.length == 1 && postorder.length == 1) {
	    		return new TreeNode(inorder[0]);
	    	}
	    	TreeNode root = new TreeNode(postorder[postorder.length - 1]);
	    	int root_inorderIndex = findIndex(inorder, root.val);
	    	int[] leftInorder = Arrays.copyOfRange(inorder, 0, root_inorderIndex);
	    	int[] rightInorder = Arrays.copyOfRange(inorder, root_inorderIndex + 1, inorder.length);
	    	int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
	    	int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, leftInorder.length + rightInorder.length);
	    	root.left = buildTree(leftInorder, leftPostorder);
	    	root.right = buildTree(rightInorder, rightPostorder);
	    	return root;
	    }
	    
	    private int findIndex(int[] array, int val) {
			int index = -1;
			for(int i = 0; i < array.length; i++) {
				if(array[i] == val) {
					index = i;
					break;
				}
			}
			return index;
		}
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
