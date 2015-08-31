package medium;

import java.util.Arrays;

public class ID_106_ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public TreeNode sortedArrayToBST(int[] nums) {
	        TreeNode root = null;
	        if(nums.length == 0) {
	        	return null;
	        }
	        else if(nums.length == 1) {
	        	return new TreeNode(nums[0]);
	        }
	        else {
	        	int mid = (int) Math.ceil(nums.length / 2.0);
	        	root = new TreeNode(nums[mid - 1]);
	        	root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid - 1));
	        	root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid, nums.length));
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
